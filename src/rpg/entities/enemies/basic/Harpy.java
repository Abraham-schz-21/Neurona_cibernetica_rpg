package rpg.entities.enemies.basic;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

/**
 * Clase que representa a un Slime básico.
 *
 * @author [AbrahamDell]
 */
public class Harpy extends Enemy {
    /**
     * Constructor que inicializa el Slime básico.
     */
    public Harpy() {
        super("Harpy", EnemyType.BASIC);
    }

    /**
     * Obtiene el botín del Slime básico.
     */
    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "Harpy suelta una pocion de envenenamiento.");
    }

    /**
     * Inicializa las estadísticas del Slime básico.
     */
    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 20);
        this.stats.put(Stats.HP, 20);
        this.stats.put(Stats.ATTACK, 2);
        this.stats.put(Stats.DEFENSE, 1);
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