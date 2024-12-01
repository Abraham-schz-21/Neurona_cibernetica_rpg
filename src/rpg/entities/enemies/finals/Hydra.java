package rpg.entities.enemies.finals;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class Hydra extends Enemy {

    public Hydra() {

        super("Hydra");
        ImageCache.addImage("hydraSprite", "hydra.png");
    }

    @Override
    public void getLoot() {
        System.out.println("The Hydra drops a Fang weapon with poison and bleed damage, plus a few coins.");
    }

    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 85);
        this.stats.put(Stats.HP, 85);
        this.stats.put(Stats.ATTACK, 40);
        this.stats.put(Stats.DEFENSE, 15);
        this.stats.put(Stats.EXPERIENCE, 50);
        this.stats.put(Stats.GOLD, 30);
    }

    @Override
    public String attack(GameCharacter enemy) {
        String message;
        // Se elige un número aleatorio entre 1 y 100
        int random = Randomize.getRandomInt(1, 100);
        // 50% de probabilidad de atacar normalmente
        // 25% de probabilidad de morder
        // 25% de probabilidad de lanzar una roca
        int attack = (random <= 40) ? 17 : (random <= 70) ? 15 : 1;
        // Se elige el ataque a realizar
        switch (attack) {
            case 1:
                try {
                    message = throwMultipleBite(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Las cabezas de la hydra atacan de forma sincronizada, 
                            mordiendo a un enemigo te hace 15 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = poisonousBreath(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Una o varias cabezas de la hydra exhalan una nube de gas tóxico que permanece
                            en el campo de batalla, infligiendo daño con el tiempo y reduciendo
                            la velocidad de movimiento, te hace 17 de daño.
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

    protected String throwMultipleBite(GameCharacter enemy) throws EnemyDeathException {
        int damage = 15;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza un ataque multiple a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    protected String poisonousBreath(GameCharacter enemy) throws EnemyDeathException {
        int damage = 17;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza una nube de gas toxico a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    @Override
    public ImageIcon getSprite() {

        return ImageCache.getImageIcon("hydraSprite");
    }
}