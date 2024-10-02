package rpg.entities;

import rpg.enums.Stats;

/**
 * Clase que representa al jugador.
 *
 * @author [AbrahamDell]
 */
public class Player extends GameCharacter {
    /**
     * Constructor que inicializa el jugador con un nombre.
     *
     * @param name Nombre del jugador.
     */
    public Player(String name) {
        super(name);
    }

    /**
     * Inicializa las estadísticas del jugador.
     */
    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.ATTACK, 35);
        this.stats.put(Stats.DEFENSE, 15);
    }
}
