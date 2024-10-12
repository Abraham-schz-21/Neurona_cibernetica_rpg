package rpg.items.armors;

import rpg.enums.ItemType;
import rpg.items.armors.Armor;

/**
 * Clase WoodArmor que representa una armadura de madera en el juego.
 */
public class WoodArmor extends Armor {



    /**
     * Constructor de la clase WoodHelmet.
     */
    public WoodArmor() {
        super("Armadura de madera", "Una armadura hecha de madera resistente.", 50, ItemType.ARMOR);
    }

    @Override
    protected void initItem() {
        this.name = "Armadura de madera";
        this.description = "Una armadura hecha de madera resistente.";
        this.price = 50;
        this.itemType = ItemType.ARMOR;

    }


}