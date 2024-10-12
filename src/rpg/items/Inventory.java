package rpg.items;

import rpg.items.armors.Armor;
import rpg.items.miscs.Misc;
import rpg.items.weapons.Weapon;
import rpg.items.Item;
import java.util.ArrayList;

/**
 * Clase Inventory que representa el inventario de un personaje en el juego.
 */
public class Inventory {

    private ArrayList<Item> items;
    private int capacity;


    /**
     * Constructor de la clase Inventory.
     *
     * @param capacity La capacidad del inventario.
     */
    public Inventory(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    /**
     * Método que agrega un objeto al inventario.
     *
     * @param item El objeto a agregar.
     */
    public void addItem(Item item) {
        if (items.size() < capacity) {
            items.add(item);
        } else {
            System.out.println("Inventario lleno");
        }
    }

    /**
     * Método que elimina un objeto del inventario.
     *
     * @param item El objeto a eliminar.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Método que devuelve un objeto del inventario por índice.
     *
     * @param index El índice del objeto.
     * @return El objeto en el índice especificado.
     */
    public Item getItem(int index) {
        return items.get(index);
    }

    /**
     * Método que devuelve la cantidad de objetos en el inventario.
     *
     * @return La cantidad de objetos en el inventario.
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Método que verifica si el inventario está lleno.
     *
     * @return True si el inventario está lleno, false en caso contrario.
     */
    public boolean isFull() {
        return items.size() == capacity;
    }

    /**
     * Método que verifica si el inventario está vacío.
     *
     * @return True si el inventario está vacío, false en caso contrario.
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Método que limpia el inventario.
     */
    public void clear() {
        items.clear();
    }

    /**
     * Método que aumenta la capacidad del inventario.
     *
     * @param amount La cantidad de espacio adicional.
     */
    public void increaseCapacity(int amount) {
        capacity += amount;
        items.ensureCapacity(capacity);
    }

    /**
     * Método que devuelve una lista de armaduras en el inventario.
     *
     * @return La lista de armaduras en el inventario.
     */
    public ArrayList<Armor> getArmors() {
        ArrayList<Armor> armors = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Armor) {
                armors.add((Armor) item);
            }
        }
        return armors;
    }

    /**
     * Método que devuelve una lista de objetos misceláneos en el inventario.
     *
     * @return La lista de objetos misceláneos en el inventario.
     */
    public ArrayList<Misc> getMiscs() {
        ArrayList<Misc> miscs = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Misc) {
                miscs.add((Misc) item);
            }
        }
        return miscs;
    }

    public ArrayList<Weapon> getWeapons() {
        ArrayList<Weapon> weapons = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Weapon) {
                weapons.add((Weapon) item);
            }
        }
        return weapons;
    }
}


