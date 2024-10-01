package rpg.entities.enemies.secret;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

public class ShadowAssassin extends Enemy {
    public ShadowAssassin() {
        super("Shadow Assassin", EnemyType.SECRET);
    }

    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, " The Shadow Assassin drops a rare dagger.");
    }

    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 180);
        this.stats.put(Stats.HP, 180);
        this.stats.put(Stats.ATTACK, 30);
        this.stats.put(Stats.DEFENSE, 25);
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
