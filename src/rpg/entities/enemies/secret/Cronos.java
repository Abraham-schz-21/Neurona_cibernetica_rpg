package rpg.entities.enemies.secret;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

/**
 * Clase que representa al Asesino de las Sombras.
 *
 * @author [AbrahamDell]
 */
public class Cronos extends Enemy {
    /**
     * Constructor que inicializa al Asesino de las Sombras.
     */
    public Cronos() {
        super("Cronos", EnemyType.SECRET);
    }

    /**
     * Obtiene el botín del Asesino de las Sombras.
     */
    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "Cronos deja caer una espada rara.");
    }

    /**
     * Inicializa las estadísticas del Asesino de las Sombras.
     */
    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 180);
        this.stats.put(Stats.HP, 180);
        this.stats.put(Stats.ATTACK, 30);
        this.stats.put(Stats.DEFENSE, 25);
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