package rpg.utils;

import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.basic.BasicSlime;
import rpg.entities.enemies.basic.RookieGoblin;
import rpg.entities.enemies.medium.EliteGoblin;
import rpg.entities.enemies.medium.ElderSlime;
import rpg.entities.enemies.finals.Dragon;
import rpg.entities.enemies.finals.DemonLord;
import rpg.entities.enemies.secret.AncientDragon;
import rpg.entities.enemies.secret.ShadowAssassin;

import javax.swing.*;
import java.util.Random;

/**
 * Clase que proporciona métodos para generar números aleatorios.
 *
 * @author [AbrahamDell]
 */
public class Randomize {
    /**
     * Generador de números aleatorios.
     */
    private static Random random = new Random();

    /**
     * Obtiene un booleano aleatorio.
     *
     * @return Booleano aleatorio.
     */
    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    /**
     * Obtiene un enemigo aleatorio.
     *
     * @return Enemigo aleatorio.
     */
    public static Enemy getRandomEnemy() {
        Enemy[] enemies = {
                new BasicSlime(),
                new RookieGoblin(),
                new EliteGoblin(),
                new ElderSlime(),
                new Dragon(),
                new DemonLord(),
                new AncientDragon(),
                new ShadowAssassin()
        };
        return enemies[random.nextInt(enemies.length)];
    }
}