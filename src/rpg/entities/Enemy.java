package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;
import java.util.Map;

public class Enemy {
    private String name;
    private Map<Stats, Integer> stats;

    public Enemy(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        // Inicializar los stats del enemigo
        stats.put(Stats.HP, 80);
        stats.put(Stats.MAX_HP, 80);
        stats.put(Stats.MP, 30);
        stats.put(Stats.MAX_MP, 30);
        stats.put(Stats.ATTACK, 12);
        stats.put(Stats.DEFENSE, 8);
        stats.put(Stats.SPEED, 6);
        stats.put(Stats.DEXTERITY, 3);
        stats.put(Stats.LUCK, 2);
        stats.put(Stats.ACCURACY, 70);
        stats.put(Stats.EVASION, 15);
        stats.put(Stats.CRITICAL_HIT_CHANCE, 5);
        stats.put(Stats.CRITICAL_HIT_DAMAGE, 1);
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

    public void takeDamage(int damage) {
        if (isAlive()) {
            int hp = stats.get(Stats.HP);
            hp -= damage;
            stats.put(Stats.HP, Math.max(hp, 0));
            System.out.println(name + " recibe " + damage + " puntos de daño.");
        } else {
            System.out.println(name + " ya está muerto.");
        }
    }

    public void attack(Player player) {
        if (isAlive()) {
            int damage = stats.get(Stats.ATTACK);
            // Calcula el daño final
            damage = (int) (damage * (1 + (stats.get(Stats.CRITICAL_HIT_CHANCE) / 100.0)));
            // Aplica el daño al jugador
            player.takeDamage(damage);
            System.out.println(name + " ataca a " + player.getName() + " por " + damage + " puntos de daño.");
        } else {
            System.out.println(name + " está muerto y no puede atacar.");
        }
    }
}
