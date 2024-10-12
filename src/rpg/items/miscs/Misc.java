package rpg.items.miscs;
import rpg.enums.ItemType;
import rpg.items.Item;

/**
 * Clase Misc que representa un objeto misceláneo en el juego.
 */
public abstract class Misc extends Item {

    /**
     * Constructor de la clase Misc.
     *
     * @param name          El nombre del objeto misceláneo.
     * @param description  La descripción del objeto misceláneo.
     * @param price         El precio del objeto misceláneo.
     */
    public Misc(String name, String description, int price) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = ItemType.MISC;
    }
}
