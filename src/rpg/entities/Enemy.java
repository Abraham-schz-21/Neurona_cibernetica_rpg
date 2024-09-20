package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Enemy {
    private String name;
    private Map<Stats, Integer> stats;

    public Enemy(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        initializeStats();
    }

    private void initializeStats() {
        // Inicializa los stats del enemigo con valores predeterminados
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

    public void attack(Player player) {
        int damage = stats.get(Stats.ATTACK) - player.getStats().get(Stats.DEFENSE);
        if (damage < 0) {
            damage = 0;
        }

        player.takeDamage(damage);
        JOptionPane.showMessageDialog(null, name + " atacó a " + player.getName() + " por " + damage + " de daño.");
        if (!player.isAlive()) {
            JOptionPane.showMessageDialog(null, player.getName() + " ha sido derrotado.");
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
