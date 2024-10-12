package rpg.items.armors;
import rpg.items.armors.Armor;
import rpg.enums.ItemType;

/**
 * Clase GoldArmor que representa una armadura de diamante en el juego.
 */
public class GoldArmor extends Armor {

    /**
     * Constructor de la clase DiamondArmor.
     */
    public GoldArmor() {
        super("Armadura de oro", "Una armadura hecha de oro mitico.", 200, ItemType.ARMOR);
    }

    @Override
    protected void initItem() {
        this.name = "Armadura de oro";
        this.description = "Una armadura hecha de oro mitico.";
        this.price = 200;
        this.itemType = ItemType.ARMOR;
    }
}