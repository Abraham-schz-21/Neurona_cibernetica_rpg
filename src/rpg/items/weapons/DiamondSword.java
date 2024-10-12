package rpg.items.weapons;

import rpg.enums.ItemType;
import rpg.items.weapons.Weapon;

/**
 * Clase DiamondSword que representa una espada de diamante en el juego.
 */
public class DiamondSword extends Weapon {

    /**
     * Constructor de la clase DiamondSword.
     */
    public DiamondSword() {
        super("Espada de diamante", "Una espada hecha de diamante genuino.", 300, ItemType.WEAPON);
    }

    @Override
    protected void initItem() {
        this.name = "Espada de diamante";
        this.description = "Una espada hecha de diamante genuino.";
        this.price = 300;
        this.itemType = ItemType.WEAPON;

    }
}

