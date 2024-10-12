package rpg.items.armors;

import rpg.items.armors.Armor;
import rpg.enums.ItemType;
/**
 * Clase DiamondArmor que representa una armadura de diamante en el juego.
 */
public class DiamondArmor extends Armor {

    /**
     * Constructor de la clase DiamondArmor.
     */
    public DiamondArmor() {
        super("Armadura de diamante", "Una armadura hecha de diamante genuino.", 250, ItemType.ARMOR);
    }

    @Override
    protected void initItem() {
        this.name = "Armadura de diamante";
        this.description = "Una armadura hecha de diamante genuino.";
        this.price = 250;
        this.itemType = ItemType.ARMOR;

    }
}
