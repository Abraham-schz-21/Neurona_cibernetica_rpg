package rpg.items.miscs;

import rpg.items.miscs.Misc;

/**
 * Clase Deer Pelt que representa una piel de ciervo en el juego.
 */
public class DeerPelt extends Misc {

    @Override
    protected void initItem() {

    }
    /**
     * Constructor de la clase DeerPelt.
     */
    public DeerPelt() {
        super("Piel de ciervo", "Una piel de ciervo con aumento de agilidad.", 25);
    }


}