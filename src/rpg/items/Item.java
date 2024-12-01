package rpg.items;

import rpg.enums.ItemType;
import java.io.Serializable;

/**
 * Clase Item que representa un objeto generico en el juego.
 */
public abstract class Item implements Serializable {

    protected String name;
    protected String description;
    protected int price;
    protected ItemType type;

    /**
     * Constructor de la clase Item.
     */
    public Item(String name, String description, int price, ItemType type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        initItem();
    }

    public Item() {
    }

    /**
     * Método abstracto que inicializa los atributos del Item.
     */
    protected abstract void initItem();

    /**
     * Getter para el nombre del Item.
     *
     * @return El nombre del Item.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter para la descripción del Item.
     *
     * @return La descripción del Item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter para el precio del Item.
     *
     * @return El precio del Item.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Getter para el tipo del Item.
     *
     * @return El tipo del Item.
     */
    public ItemType getType() {
        return type;
    }
}