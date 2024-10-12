package rpg.items.weapons;
import rpg.enums.ItemType;
import rpg.items.weapons.Weapon;

/**
 * Clase GoldSword que representa una espada de oro en el juego.
 */
public class GoldSword extends Weapon {

    /**
     * Constructor de la clase GoldSword.
     */
    public GoldSword() {
        super("Espada de oro", "Una espada hecha de oro mitico.", 250, ItemType.WEAPON);
    }

    @Override
    protected void initItem() {
        this.name = "Espada de oro";
        this.description = "Una espada hecha de oro mitico.";
        this.price = 250;
        this.itemType = ItemType.WEAPON;
    }
}
