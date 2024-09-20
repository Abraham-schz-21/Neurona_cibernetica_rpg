package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Player {
    private String name;
    private Map<Stats, Integer> stats;

    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        initializeStats();
    }

    private void initializeStats() {
        // Inicializa los stats del jugador con valores predeterminados
        stats.put(Stats.HP, 100);
        stats.put(Stats.MAX_HP, 100);
        stats.put(Stats.MP, 50);
        stats.put(Stats.MAX_MP, 50);
        stats.put(Stats.ATTACK, 15);
        stats.put(Stats.DEFENSE, 10);
        stats.put(Stats.SPEED, 8);
        stats.put(Stats.DEXTERITY, 5);
        stats.put(Stats.LUCK, 3);
        stats.put(Stats.ACCURACY, 80);
        stats.put(Stats.EVASION, 20);
        stats.put(Stats.CRITICAL_HIT_CHANCE, 10);
        stats.put(Stats.CRITICAL_HIT_DAMAGE, 2);
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
        JOptionPane.showMessageDialog(null, name + " atacó a " + enemy.getName() + " por " + damage + " de daño.");
        if (!enemy.isAlive()) {
            JOptionPane.showMessageDialog(null, enemy.getName() + " ha sido derrotado.");
        }
    }

    public void takeDamage(int damage) {
        stats.put(Stats.HP, stats.get(Stats.HP) - damage);
        if (stats.get(Stats.HP) < 0) {
            stats.put(Stats.HP, 0);
        }
        JOptionPane.showMessageDialog(null, name + " recibió " + damage + " de daño.");
        if (!isAlive()) {
            JOptionPane.showMessageDialog(null, name + " ha sido derrotado.");
        }
    }
}
