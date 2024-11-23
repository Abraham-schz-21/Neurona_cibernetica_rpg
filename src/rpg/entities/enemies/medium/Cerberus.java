package rpg.entities.enemies.medium;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.cache.ImageCache;

/**
 * Clase que representa a un Cerberus.
 *
 * @author [AbrahamDell]
 */
public class Cerberus extends Enemy {
    /**
     * Constructor que inicializa el Cerberus.
     */
    public Cerberus() {
        super("Cerberus");
        ImageCache.addImage("cerberusSprite", "cerberus.png"); // Asegúrate de que la ruta sea correcta
        initCharacter(); // Inicializa las estadísticas del Satyr
    }


    /**
     * Obtiene el botín del Cerberus.
     */
    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "El Cerbero suelta una espada de fuego.");
    }

    /**
     * Inicializa las estadísticas del Cerberus.
     */
    @Override
    protected void initCharacter() {
        this.type = EnemyType.MEDIUM;
        this.stats.put(Stats.MAX_HP, 40);
        this.stats.put(Stats.HP, 40);
        this.stats.put(Stats.ATTACK, 6);
        this.stats.put(Stats.DEFENSE, 3);
        this.stats.put(Stats.EXPERIENCE, 100);
        this.stats.put(Stats.GOLD, 50);
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

    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("cerberusSprite");
    }
}