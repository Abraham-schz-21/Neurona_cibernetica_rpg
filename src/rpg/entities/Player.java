package rpg.entities;

import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;

import java.util.Map;

/**
 * Clase que representa al jugador en el juego de RPG.
 */
public class Player {
    private String name;
    private Map<Stats, Integer> stats;

    /**
     * Crea un nuevo jugador con el nombre y stats dados.
     *
     * @param name Nombre del jugador.
     * @param stats Stats del jugador.
     */
    public Player(String name, Map<Stats, Integer> stats) {
        this.name = name;
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public Map<Stats, Integer> getStats() {
        return stats;
    }

    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    public void attack(Enemy enemy) {
        int damage = stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        if (damage < 0) {
            damage = 0;
        }

        enemy.takeDamage(damage);
        System.out.println(name + " atacó a " + enemy.getName() + " por " + damage + " de daño.");
        System.out.println("Vida restante de " + enemy.getName() + ": " + enemy.getStats().get(Stats.HP));
        if (!enemy.isAlive()) {
            System.out.println(enemy.getName() + " ha sido derrotado.");
        }
    }

    public void takeDamage(int damage) {
        stats.put(Stats.HP, stats.get(Stats.HP) - damage);
        if (stats.get(Stats.HP) < 0) {
            stats.put(Stats.HP, 0);
        }
        System.out.println(name + " recibió " + damage + " de daño.");
        System.out.println("Vida restante de " + name + ": " + stats.get(Stats.HP));
        if (!isAlive()) {
            System.out.println(name + " ha sido derrotado.");
        }
    }
}
