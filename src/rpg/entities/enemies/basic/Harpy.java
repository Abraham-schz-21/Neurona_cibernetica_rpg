package rpg.entities.enemies.basic;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.cache.ImageCache;

/**
 * Clase que representa a un Harpy básico.
 *
 * @author [AbrahamDell]
 */
public class Harpy extends Enemy {
    /**
     * Constructor que inicializa Harpy.
     */
    public Harpy() {
        super("Harpy");
        ImageCache.addImage("harpySprite", "harpy.png");
    }
    /**
     * Inicializa las estadísticas de Harpy.
     */
    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 20);
        this.stats.put(Stats.HP, 20);
        this.stats.put(Stats.ATTACK, 2);
        this.stats.put(Stats.DEFENSE, 1);
        this.stats.put(Stats.EXPERIENCE, 20);
        this.stats.put(Stats.GOLD, 25);
    }

    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("harpySprite");
    }

    /**
     * Obtiene el botín de Harpy.
     */
    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "Harpy suelta una pocion de envenenamiento.");
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