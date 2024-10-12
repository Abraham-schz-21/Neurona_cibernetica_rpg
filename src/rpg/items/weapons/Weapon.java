package rpg.items.weapons;

import rpg.enums.ItemType;
import rpg.items.Equipment;

/**
 * Clase Weapon que representa un arma en el juego.
 */
public abstract class Weapon extends Equipment {

    protected ItemType itemType;

    /**
     * Constructor de la clase Weapon.
     *
     * @param name          El nombre del arma.
     * @param description  La descripción del arma.
     * @param price         El precio del arma.
     * @param itemType    El tipo de arma.
     */
    public Weapon(String name, String description, int price, ItemType itemType) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = ItemType.WEAPON;
    }

    /**
     * Getter para el tipo de arma.
     *
     * @return El tipo de arma.
     */
    public ItemType getWeaponType() {
        return itemType;
    }
}
