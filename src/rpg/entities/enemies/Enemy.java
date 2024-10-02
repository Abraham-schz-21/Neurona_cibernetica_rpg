package rpg.entities.enemies;

import rpg.entities.GameCharacter;
import rpg.enums.EnemyType;

/**
 * Clase abstracta que representa a un enemigo.
 *
 * @author [AbrahamDell]
 */
public abstract class Enemy extends GameCharacter {
    /**
     * Tipo de enemigo.
     */
    protected EnemyType type;

    /**
     * Constructor que inicializa el enemigo con un nombre y tipo.
     *
     * @param name Nombre del enemigo.
     * @param type Tipo de enemigo.
     */
    public Enemy(String name, EnemyType type) {
        super(name);
        this.type = type;
    }

    /**
     * Método abstracto que debe ser implementado por las clases que hereden de Enemy.
     * Obtiene el botín del enemigo.
     */
    public abstract void getLoot();

    /**
     * Obtiene el tipo de enemigo.
     *
     * @return Tipo de enemigo.
     */
    public EnemyType getType() {
        return type;
    }
}