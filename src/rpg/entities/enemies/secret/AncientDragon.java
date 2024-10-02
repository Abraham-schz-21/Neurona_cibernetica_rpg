package rpg.entities.enemies.secret;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

/**
 * Clase que representa al Dragón antiguo.
 *
 * @author [AbrahamDell]
 */
public class AncientDragon extends Enemy {
    /**
     * Constructor que inicializa al Dragón antiguo.
     */
    public AncientDragon() {
        super("Ancient Dragon", EnemyType.SECRET);
    }

    /**
     * Obtiene el botín del Dragón antiguo.
     */
    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "El Dragón Antiguo deja caer una espada mítica.");
    }

    /**
     * Inicializa las estadísticas del Dragón antiguo.
     */
    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 150);
        this.stats.put(Stats.HP, 150);
        this.stats.put(Stats.ATTACK, 25);
        this.stats.put(Stats.DEFENSE, 20);
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
        JOptionPane.showMessageDialog(null, String.format("%s ataca a %s por %d daño! %s tiene %d HP restantes.%n",
                this.name, enemyName, damage, enemyName, newHP));
    }
}