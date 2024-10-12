package rpg.items.weapons;
import rpg.enums.ItemType;
import rpg.items.weapons.Weapon;

/**
 * Clase IronSword que representa una espada de hierro en el juego.
 */
public class IronSword extends Weapon {

    /**
     * Constructor de la clase IronSword.
     */
    public IronSword() {
        super("Espada de hierro", "Una espada hecha de hierro forjado.", 200, ItemType.WEAPON);
    }

    @Override
    protected void initItem() {
        this.name = "Espada de hierro";
        this.description = "Una espada hecha de hierro forjado.";
        this.price = 200;
        this.itemType = ItemType.WEAPON;
    }
}

