package rpg.entities.enemies.finals;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

/**
 * Clase que representa a Hydra.
 *
 * @author [AbrahamDell]
 */
public class Hydra extends Enemy {
    /**
     * Constructor que inicializa a Hydra.
     */
    public Hydra() {
        super("Hydra", EnemyType.FINAL);
    }

    /**
     * Obtiene el botín de Hydra.
     */
    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "Hydra suelta una armadura de serpientes.");
    }

    /**
     * Inicializa las estadísticas de Hydra.
     */
    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.ATTACK, 15);
        this.stats.put(Stats.DEFENSE, 10);
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