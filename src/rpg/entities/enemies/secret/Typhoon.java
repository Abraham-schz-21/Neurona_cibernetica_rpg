package rpg.entities.enemies.secret;
import javax.swing.*;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.cache.ImageCache;

/**
 * Clase que representa al Typhoon.
 *
 * @author [AbrahamDell]
 */
public class Typhoon extends Enemy {
    /**
     * Constructor que inicializa al Typhoon.
     */
    public Typhoon() {
        super("Typhoon");
        ImageCache.addImage("typhoonSprite", "typhoon.png"); // Asegúrate de que la ruta sea correcta
        initCharacter(); // Inicializa las estadísticas del Satyr
    }

    /**
     * Obtiene el botín del Typhoon.
     */
    @Override
    public void getLoot() {
        JOptionPane.showMessageDialog(null, "El Typhoon deja caer una espada electrica.");
    }

    /**
     * Inicializa las estadísticas del Typhoon.
     */
    @Override
    protected void initCharacter() {
        this.type = EnemyType.SECRET;
        this.stats.put(Stats.MAX_HP, 150);
        this.stats.put(Stats.HP, 150);
        this.stats.put(Stats.ATTACK, 150);
        this.stats.put(Stats.DEFENSE, 70);
        this.stats.put(Stats.EXPERIENCE, 150);
        this.stats.put(Stats.GOLD, 75);
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

    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("typhoonSprite");
    }
}