package rpg.entities.enemies.secret;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class Typhoon extends Enemy {

    public Typhoon() {

        super("Typhoon");
        ImageCache.addImage("typhoonSprite", "typhoon.png");
    }

    @Override
    public void getLoot() {
        System.out.println("The typhoon drops a legendary weapon Legendary Trident of Chaos and some coins");
    }

    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 75);
        this.stats.put(Stats.HP, 75);
        this.stats.put(Stats.ATTACK, 30);
        this.stats.put(Stats.DEFENSE, 20);
        this.stats.put(Stats.EXPERIENCE, 35);
        this.stats.put(Stats.GOLD, 25);
    }

    @Override
    public String attack(GameCharacter enemy) {
        String message;
        // Se elige un número aleatorio entre 1 y 100
        int random = Randomize.getRandomInt(1, 100);
        // 50% de probabilidad de atacar normalmente
        // 25% de probabilidad de morder
        // 25% de probabilidad de lanzar una roca
        int attack = (random <= 50) ? 25 : (random <= 75) ? 21 : 1;
        // Se elige el ataque a realizar
        switch (attack) {
            case 1:
                try {
                    message = throwDestructivePuff(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Las cabezas de Tifón lanzan mordidas simultáneamente en diferentes direcciones, 
                            te hace 21 de daño
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = thunderstorm(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Invoca relámpagos que impactan aleatoriamente, causando daño eléctrico 
                            y aturdiendo a los enemigos, te hace 25 de daño.
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

    protected String throwDestructivePuff(GameCharacter enemy) throws EnemyDeathException {
        int damage = 21;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza mordidas a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    protected String thunderstorm(GameCharacter enemy) throws EnemyDeathException {
        int damage = 25;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza relampagos aleatorios a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    @Override
    public ImageIcon getSprite() {

        return ImageCache.getImageIcon("typhoonSprite");
    }
}