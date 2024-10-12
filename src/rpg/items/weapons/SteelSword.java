package rpg.items.weapons;
import rpg.enums.ItemType;
import rpg.items.weapons.Weapon;

/**
 * Clase SteelSword que representa una espada de acero en el juego.
 */
public class SteelSword extends Weapon {

    /**
     * Constructor de la clase SteelSword.
     */
    public SteelSword() {
        super("Espada de acero", "Una espada hecha de acero fuerte.", 150, ItemType.WEAPON);
    }

    @Override
    protected void initItem() {
        this.name = "Espada de acero";
        this.description = "Una espada hecha de acero fuerte.";
        this.price = 150;
        this.itemType = ItemType.WEAPON;
    }
}
