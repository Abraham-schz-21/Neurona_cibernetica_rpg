package rpg;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.utils.Randomize;

import javax.swing.*;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Player player = new Player("Zeus");
        Enemy enemy = Randomize.getRandomEnemy();
        JOptionPane.showMessageDialog(null, "Estas luchando contra un " + enemy.getName());
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }
        if (player.isAlive()) {
            JOptionPane.showMessageDialog(null, "Ganaste!");
        } else {
            JOptionPane.showMessageDialog(null, "Perdiste!");
        }
    }
}
