package rpg.entities;

import rpg.enums.Stats;

import javax.swing.*;
import java.util.HashMap;

public abstract class GameCharacter {
    protected String name;
    protected HashMap<Stats, Integer> stats;

    public GameCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        initCharacter();
    }

    protected abstract void initCharacter();

    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    public void attack(GameCharacter enemy) {
        String message = "";
        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        int newHP = enemy.getStats().get(Stats.HP);
        if (damage > 0) {
            newHP = enemy.getStats().get(Stats.HP) - damage;
            enemy.getStats().put(Stats.HP, newHP);
            message += String.format("%s ataca a %s por %d de daño! A %s le quedan %d HP.%n",
                    this.name, enemyName, damage, enemyName, newHP);
        } else {
            message += String.format("%s ataca a %s pero no hace daño! A %s le quedan %d HP.%n",
                    this.name, enemyName, enemyName, newHP);
        }
        JOptionPane.showMessageDialog(null, message);
    }

    public String getName() {
        return name;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}
