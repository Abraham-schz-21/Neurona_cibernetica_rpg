package rpg.items.armors;

import rpg.items.armors.Armor;
import rpg.enums.ItemType;

/**
 * Clase IronArmor que representa una armadura de hierro en el juego.
 */
public class IronArmor extends Armor {

    /**
     * Constructor de la clase IronArmor.
     */
    public IronArmor() {
        super("Armadura de hierro", "Una armadura hecha de hierro forjado.", 150, ItemType.ARMOR);
    }

    @Override
    protected void initItem() {
        this.name = "Armadura de hierro";
        this.description = "Una armadura hecha de hierro forjado.";
        this.price = 150;
        this.itemType = ItemType.ARMOR;
    }
}
