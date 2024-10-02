package rpg.entities.enemies.medium;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

/**
 * Clase que representa a un Goblin élite.
 *
 * @author [AbrahamDell]
 */
public class EliteGoblin extends Enemy {
    /**
     * Constructor que inicializa el Goblin élite.
     */
    public EliteGoblin() {
        super("Elite Goblin", EnemyType.MEDIUM);
    }

    /**
     * Obtiene el botín del Goblin élite.
     */
    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "El Goblin Élite suelta una espada fina.");
    }

    /**
     * Inicializa las estadísticas del Goblin élite.
     */
    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 30);
        this.stats.put(Stats.HP, 30);
        this.stats.put(Stats.ATTACK, 5);
        this.stats.put(Stats.DEFENSE, 2);
    }

    /**
     * Ataca a un enemigo.
     *
     * @param enemy Enemigo a atacar.
     */
    @Override
    public void attack(GameCharacter enemy) {
        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK) - enemy .getStats().get(Stats.DEFENSE);
        int newHP = enemy.getStats().get(Stats.HP) - damage;
        enemy.getStats().put(Stats.HP, newHP);
        JOptionPane.showMessageDialog(null, String.format("%s ataca a %s por %d de daño! A %s le quedan %d HP.%n",
                this.name, enemyName, damage, enemyName, newHP));
    }
}