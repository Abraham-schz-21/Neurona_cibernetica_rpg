package rpg.items.miscs;

import rpg.items.Item;

public class Misc extends Item {
    private int quantity;

    public Misc(String name, String description, int price) {
        super();
        this.quantity = 1; // Inicializar cantidad
    }

    @Override
    protected void initItem() {
        // Aquí puedes inicializar cualquier lógica adicional para el ítem si es necesario
    }
    public boolean isStackable() {
        return true; // O lógica para determinar si es apilable
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
        if (this.quantity < 0) this.quantity = 0;
    }

    public int getQuantity() {
        return quantity;
    }
}
