package rpg.items.miscs;

import rpg.items.miscs.Misc;

/**
 * Clase BearPelt que representa una piel de oso en el juego.
 */
public class BearPelt extends Misc {

    @Override
    protected void initItem() {

    }
    /**
     * Constructor de la clase BearPelt.
     */
    public BearPelt() {
        super("Piel de oso", "Una piel de oso con habilidad de fuerza.", 25);
    }

}
