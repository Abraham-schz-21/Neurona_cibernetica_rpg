package rpg.items.armors;


import rpg.enums.ItemType;
import rpg.items.Equipment;

/**
 * Clase Armor que representa una armadura en el juego.
 */
public abstract class Armor extends Equipment {

    protected ItemType itemType;

    /**
     * Constructor de la clase Armor.
     *
     * @param name          El nombre de la armadura.
     * @param description  La descripción de la armadura.
     * @param price         El precio de la armadura.
     * @param itemType     El tipo de armadura.
     */
    public Armor(String name, String description, int price, ItemType itemType) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = ItemType.ARMOR;

    }

    /**
     * Getter para el tipo de armadura.
     *
     * @return El tipo de armadura.
     */
    public ItemType getArmorType() {
        return itemType;
    }
}
