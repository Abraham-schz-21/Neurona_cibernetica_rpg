package rpg.items.miscs;

import rpg.items.miscs.Misc;

/**
 * Clase RabbitPelt que representa una piel de conejo en el juego.
 */
public class RabbitPelt extends Misc {

    @Override
    protected void initItem() {

    }
    /**
     * Constructor de la clase RabbitPelt.
     */
    public RabbitPelt() {
        super("Piel de conejo", "Una piel de conejo con habilidad de salto.", 25);
    }


}