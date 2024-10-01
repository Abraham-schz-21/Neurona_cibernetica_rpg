package rpg.entities.enemies.medium;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

public class EliteGoblin extends Enemy {
    public EliteGoblin() {
        super("Elite Goblin", EnemyType.MEDIUM);
    }

    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "The Elite Goblin drops a fine sword.");
    }

    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 30);
        this.stats.put(Stats.HP, 30);
        this.stats.put(Stats.ATTACK, 5);
        this.stats.put(Stats.DEFENSE, 2);
    }

    @Override
    public void attack(GameCharacter enemy) {
        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        int newHP = enemy.getStats().get(Stats.HP) - damage;
        enemy.getStats().put(Stats.HP, newHP);
        JOptionPane.showMessageDialog(null, String.format("%s attacks %s for %d damage! %s has %d HP left.%n",
                this.name, enemyName, damage, enemyName, newHP));
    }
}
