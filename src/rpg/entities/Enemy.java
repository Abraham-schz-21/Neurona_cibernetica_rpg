package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa al enemigo en el juego de RPG.
 */
public class Enemy {
    private String name;
    private Map<Stats, Integer> stats;

    /**
     * Crea un nuevo enemigo con el nombre y stats dados.
     *
     * @param name Nombre del enemigo.
     * @param stats Stats del enemigo.
     */
    public Enemy(String name, Map<Stats, Integer> stats) {
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

    public void attack(Player player) {
        int damage = stats.get(Stats.ATTACK) - player.getStats().get(Stats.DEFENSE);
        if (damage < 0) {
            damage = 0;
        }

        player.takeDamage(damage);
        System.out.println(name + " atacó a " + player.getName() + " por " + damage + " de daño.");
        System.out.println("Vida restante de " + player.getName() + ": " + player.getStats().get(Stats.HP));
        if (!player.isAlive()) {
            System.out.println(player.getName() + " ha sido derrotado.");
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
