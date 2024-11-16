package rpg.entities.enemies.medium;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

/**
 * Clase que representa a un Minotaur.
 *
 * @author [AbrahamDell]
 */
public class Minotaur extends Enemy {
    /**
     * Constructor que inicializa el Minotaur.
     */
    public Minotaur() {
        super("Minotaur", EnemyType.MEDIUM);
    }

    /**
     * Obtiene el botín del Minotaur.
     */
    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "El Minotaur suelta habilidad de fuerza.");
    }

    /**
     * Inicializa las estadísticas del Minotaur.
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