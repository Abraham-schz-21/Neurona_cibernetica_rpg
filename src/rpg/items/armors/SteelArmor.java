package rpg.items.armors;

import rpg.items.armors.Armor;
import rpg.enums.ItemType;

/**
 * Clase SteelArmor que representa una armadura de acero en el juego.
 */
public class SteelArmor extends Armor {

    /**
     * Constructor de la clase SteelArmor.
     */
    public SteelArmor() {
        super("Armadura de acero", "Una armadura hecha de acero templado.", 100, ItemType.ARMOR);
    }

    @Override
    protected void initItem() {
        this.name = "Armadura de acero";
        this.description = "Una armadura hecha de acero templado.";
        this.price = 100;
        this.itemType = ItemType.ARMOR;

    }
}
