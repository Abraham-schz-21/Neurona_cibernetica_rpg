package rpg.entities.enemies.finals;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

/**
 * Clase que representa al Señor Demonio.
 *
 * @author [AbrahamDell]
 */
public class Jellyfish extends Enemy {
    /**
     * Constructor que inicializa al Señor Demonio.
     */
    public Jellyfish() {
        super("Jellyfish", EnemyType.FINAL);
    }

    /**
     * Obtiene el botín del Señor Demonio.
     */
    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "Jellyfish suelta una espada mitica de piedra.");
    }

    /**
     * Inicializa las estadísticas del Señor Demonio.
     */
    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 120);
        this.stats.put(Stats.HP, 120);
        this.stats.put(Stats.ATTACK, 20);
        this.stats.put(Stats.DEFENSE, 15);
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