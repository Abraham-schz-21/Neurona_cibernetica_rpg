package rpg.items;

import rpg.items.miscs.Misc;
import rpg.exceptions.ItemNotFoundException;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private int capacity;

    public Inventory() {
        this.capacity = 10; // Capacidad predeterminada
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (items.size() < capacity) {
            items.add(item);
        } else {
            System.out.println("Inventario lleno");
        }
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Misc> getMiscs() {
        ArrayList<Misc> miscs = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Misc) {
                miscs.add((Misc) item);
            }
        }
        return miscs;
    }

    public Item getItem(Item item) throws ItemNotFoundException {
        for (Item i : items) {
            if (i.equals(item)) {
                return i;
            }
        }
        throw new ItemNotFoundException(); // Lanzar excepción si no se encuentra
    }
}