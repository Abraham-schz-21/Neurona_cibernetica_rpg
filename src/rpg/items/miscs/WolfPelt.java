package rpg.items.miscs;

import rpg.items.miscs.Misc;

/**
 * Clase WolfPelt que representa una piel de lobo en el juego.
 */
public class WolfPelt extends Misc {
    @Override
    protected void initItem() {

    }

    /**
     * Constructor de la clase WolfPelt.
     */
    public WolfPelt() {
        super("Piel de lobo", "Una piel de lobo con aumento de ataque.", 25);
    }
}
