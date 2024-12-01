package rpg.utils;

import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.basic.Harpy;

import rpg.entities.enemies.basic.Satyr;
import rpg.entities.enemies.medium.Minotaur;
import rpg.entities.enemies.medium.Cerberus;
import rpg.entities.enemies.finals.Hydra;
import rpg.entities.enemies.finals.Jellyfish;
import rpg.entities.enemies.secret.Typhoon;
import rpg.entities.enemies.secret.Cronos;

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

    public static int getRandomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Obtiene un enemigo aleatorio.
     *
     * @return Enemigo aleatorio.
     */
    public static Enemy getRandomEnemy() {
        Enemy[] enemies = {
                new Harpy(),
                new Satyr(),
                new Minotaur(),
                new Cerberus(),
                new Hydra(),
                new Jellyfish(),
                new Typhoon(),
                new Cronos()

        };
        return enemies[random.nextInt(enemies.length)];
    }
}