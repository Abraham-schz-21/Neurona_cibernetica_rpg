package rpg.entities.enemies.secret;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class Cronos extends Enemy {

    public Cronos() {

        super("Cronos");
        ImageCache.addImage("cronosSprite", "cronos.png");
    }

    @Override
    public void getLoot() {
        System.out.println("Cronos drops a Heavy Scythe as a legendary weapon and some coins.");
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
        int attack = (random <= 50) ? 21 : (random <= 75) ? 18 : 1;
        // Se elige el ataque a realizar
        switch (attack) {
            case 1:
                try {
                    message = throwTitanicPunch(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Realiza un golpe masivo con su puño, causando un daño devastador en un área pequeña, 
                            te hace 18 de daño
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = turnBackTime(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Cronos activa un poder que lo cura parcialmente al deshacer 
                            el daño recibido en los últimos segundos, te hace 21 de daño.
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

    protected String throwTitanicPunch(GameCharacter enemy) throws EnemyDeathException {
        int damage = 18;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza un golpe masivo a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    protected String turnBackTime(GameCharacter enemy) throws EnemyDeathException {
        int damage = 21;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s activa un poder de curacion a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    @Override
    public ImageIcon getSprite() {

        return ImageCache.getImageIcon("cronosSprite");
    }
}