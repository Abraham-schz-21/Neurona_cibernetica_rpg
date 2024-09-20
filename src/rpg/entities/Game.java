package rpg.entities;

import rpg.entities.Enemy;
import rpg.entities.Player;

public class Game {
    private Player player;
    private Enemy enemy;

    public Game(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void startGame() {
        System.out.println("¡Bienvenido al juego de RPG!");
        System.out.println("El jugador " + player.getName() + " se enfrenta a " + enemy.getName());

        while (player.isAlive() && enemy.isAlive()) {
            // Turno del jugador
            player.attack(enemy);
            if (!enemy.isAlive()) {
                break;
            }
            // Turno del enemigo
            enemy.attack(player);
            if (!player.isAlive()) {
                break;
            }
        }

        if (player.isAlive()) {
            System.out.println(player.getName() + " ha ganado la batalla!");
        } else {
            System.out.println(enemy.getName() + " ha ganado la batalla!");
        }
    }

    public static void main(String[] args) {
        Player player = new Player("Zeus");
        Enemy enemy = new Enemy("Medusa");
        Game game = new Game(player, enemy);
        game.startGame();
    }
}
