package rpg.entities.enemies.medium;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

/**
 * Clase que representa a un Slime anciano.
 *
 * @author [AbrahamDell]
 */
public class ElderSlime extends Enemy {
    /**
     * Constructor que inicializa el Slime anciano.
     */
    public ElderSlime() {
        super("Elder Slime", EnemyType.MEDIUM);
    }

    /**
     * Obtiene el botín del Slime anciano.
     */
    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "El Slime Anciano suelta un amuleto mágico.");
    }

    /**
     * Inicializa las estadísticas del Slime anciano.
     */
    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 40);
        this.stats.put(Stats.HP, 40);
        this.stats.put(Stats.ATTACK, 6);
        this.stats.put(Stats.DEFENSE, 3);
    }

    /**
     * Ataca a un enemigo.
     *
     * @param enemy Enemigo a atacar.
     */
    @Override
    public void attack(GameCharacter enemy) {
        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        int newHP = enemy.getStats().get(Stats.HP) - damage;
        enemy.getStats().put(Stats.HP, newHP);
        JOptionPane.showMessageDialog(null, String.format("%s ataca a %s por %d de daño! A %s le quedan %d HP.%n",
                this.name, enemyName, damage, enemyName, newHP));
    }
}