package rpg.entities;

import rpg.enums.Stats;

import javax.swing.*;
import java.util.HashMap;

/**
 * Clase abstracta que representa a un personaje en el juego.
 *
 * @author [AbrahamDell]
 */
public abstract class GameCharacter {
    /**
     * Nombre del personaje.
     */
    protected String name;

    /**
     * Estadísticas del personaje.
     */
    protected HashMap<Stats, Integer> stats;

    /**
     * Constructor que inicializa el personaje con un nombre y estadísticas vacías.
     *
     * @param name Nombre del personaje.
     */
    public GameCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        initCharacter();
    }

    /**
     * Método abstracto que debe ser implementado por las clases que hereden de GameCharacter.
     * Inicializa las estadísticas del personaje.
     */
    protected abstract void initCharacter();

    /**
     * Verifica si el personaje está vivo.
     *
     * @return True si el personaje tiene HP mayor a 0, false en caso contrario.
     */
    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    /**
     * Ataca a un enemigo.
     *
     * @param enemy Enemigo a atacar.
     */
    public void attack(GameCharacter enemy) {
        String message = "";
        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        int newHP = enemy.getStats().get(Stats.HP);
        if (damage > 0) {
            newHP = enemy.getStats().get(Stats.HP) - damage;
            enemy.getStats().put(Stats.HP, newHP);
            message += String.format("%s ataca a %s por %d de daño! A %s le quedan %d HP.%n",
                    this.name, enemyName, damage, enemyName, newHP);
        } else {
            message += String.format("%s ataca a %s pero no hace daño! A %s le quedan %d HP.%n",
                    this.name, enemyName, enemyName, newHP);
        }
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Obtiene el nombre del personaje.
     *
     * @return Nombre del personaje.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene las estadísticas del personaje.
     *
     * @return Estadísticas del personaje.
     */
    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}