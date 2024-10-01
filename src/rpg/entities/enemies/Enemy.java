package rpg.entities.enemies;

import rpg.entities.GameCharacter;
import rpg.enums.EnemyType;

public abstract class Enemy extends GameCharacter {
    protected EnemyType type;

    public Enemy(String name, EnemyType type) {
        super(name);
        this.type = type;
    }

    public abstract void getLoot();

    public EnemyType getType() {
        return type;
    }
}