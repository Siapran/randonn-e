/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.world.entity.actor;

import grea.antoine.utils.Collections;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;
import rpg.rules.action.Consume;
import rpg.rules.action.GoTo;
import rpg.rules.action.Sleep;
import rpg.rules.action.StartFire;
import rpg.rules.action.Take;
import rpg.utils.Named;
import rpg.utils.Tracker;
import rpg.utils.Util;
import rpg.world.Location;
import rpg.world.Tracked;
import rpg.world.entity.Container;
import rpg.world.entity.Item;
import rpg.world.entity.item.Food;
import rpg.world.entity.item.Fuel;
import rpg.world.entity.item.food.Canned;
import rpg.world.entity.item.tool.CanOpener;

@Named(name = "joueur")
public class Player extends Human {

    private final Scanner scanner;

    public Player(Location currentLocation) {
        super("vous", currentLocation);
        scanner = new Scanner(System.in);
    }

    @Override
    public void decideNewAction() {
        System.out.print("$> ");
        String line = scanner.nextLine().trim();
        Scanner sc = new Scanner(line).useDelimiter("\\s+");
        if (sc.hasNext()) {
            String verb = sc.next();
            Tracked target;
            switch (verb) {
                case "help":
                    System.out.println("Commandes: consommer, dormir, décrire, allumer.");
                    System.out.println("Vous pouvez également taper directement le nom d'une cible pour tenter une action contextuelle.");
                    System.out.println("Mots-clés spéciaux: moi, ici");
                    break;
                case "quitter":
                    destroy();
                    break;
                case "décrire":
                    if (sc.hasNextLine()) {
                        String restOfLine = sc.nextLine().trim();
                        describeTarget(getTarget(restOfLine));
                    }
                    break;
                case "dormir":
                    if (sc.hasNextInt()) {
                        int time = sc.nextInt();
                        if (time > 0) {
                            setAction(new Sleep(time, this));
                        }
                    }
                    break;
                case "consommer":
                    if (sc.hasNextLine()) {
                        String restOfLine = sc.nextLine().trim();
                        target = getTarget(restOfLine);
                        if (target == null) {
                            System.out.println("Cible inacessible.");
                            return;
                        }
                        if (target instanceof Food) {
                            Food food = (Food) target;
                            if (food instanceof Canned) {
                                Canned canned = (Canned) food;
                                if (!getInventory().filterType(CanOpener.class).isEmpty()) {
                                    canned.open();
                                    setAction(new Consume(canned, this));
                                }
                            } else {
                                setAction(new Consume(food, this));
                            }
                        } else {
                            System.out.println(Util.capitalize(target.toString()) + " n'est pas consommable.");
                        }
                    }
                    break;
                case "allumer":
                    if (sc.hasNextLine()) {
                        String restOfLine = sc.nextLine().trim();
                        target = getTarget(restOfLine);
                        if (target == null) {
                            System.out.println("Cible inacessible.");
                            return;
                        }
                        if (target instanceof Fuel) {
                            Fuel fuel = (Fuel) target;
                            setAction(new StartFire(fuel, this));
                        } else {
                            System.out.println(Util.capitalize(target.toString()) + " n'est pas combustible.");
                        }
                    }
                    break;
                default:
                    target = getTarget(line);
                    if (getCurrentLocation().getEdges().contains(target)) {
                        setAction(new GoTo((Location) target, this));
                    } else if (target instanceof Item) {
                        Item item = (Item) target;
                        setAction(new Take(item, this));
                    } else {
                        describeTarget(target);
                    }
                    break;
            }
        }
    }

    private void describeTarget(Tracked target) {
        if (target == null || getCurrentLocation().getEdges().contains(target)) {
            System.out.println("Cible inacessible.");
            return;
        }
        System.out.println(target.description());
    }

    private Tracked getTarget(String name) {
        // look for first target with name in current context
        // TODO: implement target chooser
        switch (name) {
            case "moi":
                return this;
            case "ici":
                return getCurrentLocation();
            default:
                Tracker contained = new Tracker();
                getHolder().getTracker().filterType(Container.class).forEach((container) -> contained.addAll(((Container) container).getContents()));
                Tracker union = new Tracker(Collections.union(getInventory(), getHolder().getTracker(), getCurrentLocation().getEdges(), contained));
                union.add(getCurrentLocation());
                Optional<Tracked> res = union.stream().filter((tracked) -> (tracked.toString() == null ? name == null : tracked.toString().equals(name))).findFirst();
                if (res.isPresent()) {
                    return res.get();
                } else {
                    return null;
                }
        }
    }

    @Override
    public void destroy() {
        setHealth(0);
        super.destroy();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String description() {
        String res = super.description();
        if (!getTracker().isEmpty()) {
            res += "\ncontient:";
            for (Iterator<Tracked> iterator = getInventory().iterator(); iterator.hasNext();) {
                Tracked tracked = (Tracked) iterator.next();
                res += " " + tracked;
                if (iterator.hasNext()) {
                    res += ",";
                } else {
                    res += ".";
                }
            }
        }
        res += "\nSanté: " + (getHealth() * 100 / STATUS_MAX) + "%";
        res += "\nChaleur: " + (getWarmth() * 100 / STATUS_MAX) + "%";
        res += "\nFatigue: " + (getWeariness() * 100 / STATUS_MAX) + "%";
        res += "\nFaim: " + (getHunger() * 100 / STATUS_MAX) + "%";
        res += "\nSoif: " + (getThirst() * 100 / STATUS_MAX) + "%";
        return res;
    }

}
