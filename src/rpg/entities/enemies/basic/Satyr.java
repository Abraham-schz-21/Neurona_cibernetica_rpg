package rpg.entities.enemies.basic;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class Satyr extends Enemy {

    public Satyr() {

        super("Satyr");
        ImageCache.addImage("satyrSprite", "satyr.png");
    }

    @Override
    public void getLoot() {
        System.out.println("The satyr drops a Wild Nature Essence to restore health, with some coins.");
    }

    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 25);
        this.stats.put(Stats.HP, 25);
        this.stats.put(Stats.ATTACK, 12);
        this.stats.put(Stats.DEFENSE, 7);
        this.stats.put(Stats.EXPERIENCE, 20);
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
        int attack = (random <= 60) ? 12 : (random <= 80) ? 8 : 1;
        // Se elige el ataque a realizar
        switch (attack) {
            case 1:
                try {
                    message = throwMagicAttack(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            El Satyr ataca con onda sonora de flauta y crea una explosión circular de energía te hace 8 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = wildCharge(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            El satyr se inclina hacia adelante y embiste con sus cuernos te hace 12 de daño.
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

    protected String throwMagicAttack(GameCharacter enemy) throws EnemyDeathException {
        int damage = 8;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza una onda sonora de ataque a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    protected String wildCharge(GameCharacter enemy) throws EnemyDeathException {
        int damage = 12;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s embiste con sus cuernos a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    @Override
    public ImageIcon getSprite() {

        return ImageCache.getImageIcon("satyrSprite");
    }
}
