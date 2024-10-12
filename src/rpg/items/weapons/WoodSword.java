package rpg.items.weapons;
import rpg.enums.ItemType;
import rpg.items.weapons.Weapon;

/**
 * Clase WoodSword que representa una espada de madera en el juego.
 */
public class WoodSword extends Weapon {

    /**
     * Constructor de la clase WoodSword.
     */
    public WoodSword() {
        super("Espada de madera", "Una espada hecha de madera resistente.", 50, ItemType.WEAPON);
    }

    @Override
    protected void initItem() {
        this.name = "Espada de madera";
        this.description = "Una espada hecha de madera resistente.";
        this.price = 50;
        this.itemType = ItemType.WEAPON;


    }
}
