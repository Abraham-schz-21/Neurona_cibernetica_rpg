package rpg.entities.enemies.basic;

import javax.swing.*;
import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.cache.ImageCache;

/**
 * Clase que representa a un Satyr.
 *
 * @author [AbrahamDell]
 */
public class Satyr extends Enemy {
    /**
     * Constructor que inicializa el Satyr.
     */
    public Satyr() {
        super("Satyr");
        ImageCache.addImage("satyrSprite", "satyr.png"); // Asegúrate de que la ruta sea correcta
        initCharacter(); // Inicializa las estadísticas del Satyr
    }

    /**
     * Obtiene el botín del Satyr.
     */
    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "Satyr suelta pocion de confusión.");
    }

    /**
     * Inicializa las estadísticas del Satyr.
     */
    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 15);
        this.stats.put(Stats.HP, 15);
        this.stats.put(Stats.ATTACK, 3);
        this.stats.put(Stats.DEFENSE, 1);
        this.stats.put(Stats.EXPERIENCE, 20);
        this.stats.put(Stats.GOLD, 20);
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

    /**
     * Obtiene el sprite del Satyr.
     *
     * @return Icono de la imagen del Satyr.
     */
    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("satyrSprite");
    }
}
