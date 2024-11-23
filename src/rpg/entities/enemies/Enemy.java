package rpg.entities.enemies;

import rpg.entities.GameCharacter;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

import javax.swing.*;
import java.awt.image.BufferedImage;

public abstract class Enemy extends GameCharacter {
    protected EnemyType type;

    public Enemy(String name) {
        super(name);
    }

    public abstract ImageIcon getSprite();

    public abstract void getLoot();

    public abstract void attack(GameCharacter enemy);

    public EnemyType getType() {
        return type;
    }
}