package rpg.entities.enemies.finals;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class Jellyfish extends Enemy {

    public Jellyfish() {

        super("Jellyfish");
        ImageCache.addImage("jellyfishSprite", "jellyfish.png");
    }

    @Override
    public void getLoot() {
        System.out.println("Drops a Medusa Head weapon as a secondary weapon and some coins.");
    }

    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 95);
        this.stats.put(Stats.HP, 95);
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
                    message = throwsPetrifyingGaze(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Medusa fija su mirada en el jugador, 
                            lanzando un rayo que ralentiza progresivamente al objetivo.
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = stormOfSnakes(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            Invoca serpientes mágicas que persiguen al jugador y explotan al contacto, 
                            causando daño en área, te hace 17 de daño.
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

    protected String throwsPetrifyingGaze(GameCharacter enemy) throws EnemyDeathException {
        int damage = 15;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza mirada petrificante a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    protected String stormOfSnakes(GameCharacter enemy) throws EnemyDeathException {
        int damage = 17;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza serpientes magicas a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    @Override
    public ImageIcon getSprite() {

        return ImageCache.getImageIcon("jellyfishSprite");
    }
}