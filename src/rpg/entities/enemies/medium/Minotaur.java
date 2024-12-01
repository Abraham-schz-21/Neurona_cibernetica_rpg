package rpg.entities.enemies.medium;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class Minotaur extends Enemy {

    public Minotaur() {

        super("Minotaur");
        ImageCache.addImage("minotaurSprite", "minotaur.png");
    }

    @Override
    public void getLoot() {
        System.out.println("The minotaur drops labyrinth axe and some coins.");
    }

    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 45);
        this.stats.put(Stats.HP, 45);
        this.stats.put(Stats.ATTACK, 12);
        this.stats.put(Stats.DEFENSE, 15);
        this.stats.put(Stats.EXPERIENCE, 25);
        this.stats.put(Stats.GOLD, 10);
    }

    @Override
    public String attack(GameCharacter enemy) {
        String message;
        // Se elige un número aleatorio entre 1 y 100
        int random = Randomize.getRandomInt(1, 100);
        // 50% de probabilidad de atacar normalmente
        // 25% de probabilidad de morder
        // 25% de probabilidad de lanzar una roca
        int attack = (random <= 50) ? 15 : (random <= 75) ? 12 : 1;
        // Se elige el ataque a realizar
        switch (attack) {
            case 1:
                try {
                    message = throwHornBlow(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Utiliza sus cuernos para levantar al jugador por los aires y luego lanzarlo, 
                            causando daño por caída al aterrizar, 
                            te hace 12 de daño
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = wildWhirlwind(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Gira rápidamente con su arma (hacha o maza), causando daño continuo 
                            en un área circular a su alrededor, te hace 15 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            default:
                message = ((GameCharacter) this).attack(enemy);
                break;
        }
        return message;
    }

    protected String throwHornBlow(GameCharacter enemy) throws EnemyDeathException {
        int damage = 12;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza ataque triple a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    protected String wildWhirlwind(GameCharacter enemy) throws EnemyDeathException {
        int damage = 15;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza un ataque circular a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    @Override
    public ImageIcon getSprite() {

        return ImageCache.getImageIcon("minotaurSprite");
    }
}