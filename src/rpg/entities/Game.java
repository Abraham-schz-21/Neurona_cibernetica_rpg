package rpg.entities;

import rpg.enums.Stats;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
/**
 * Clase que representa el juego de RPG.
 */
public class Game {
    private Player player;
    private Enemy enemy;

    /**
     * Crea un nuevo juego con el jugador y el enemigo dados.
     *
     * @param player Jugador del juego.
     * @param enemy Enemigo del juego.
     */
    public Game(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void startGame() {
        // Mostrar estadísticas del jugador
        String playerStats = "Estadísticas del jugador:\n";
        playerStats += "Nombre: " + player.getName() + "\n";
        playerStats += "HP: " + player.getStats().get(Stats.HP) + "/" + player.getStats().get(Stats.MAX_HP) + "\n";
        playerStats += "MP: " + player.getStats().get(Stats.MP) + "/" + player.getStats().get(Stats.MAX_MP) + "\n";
        playerStats += "Ataque: " + player.getStats().get(Stats.ATTACK) + "\n";
        playerStats += "Defensa: " + player.getStats().get(Stats.DEFENSE) + "\n";
        playerStats += "Velocidad: " + player.getStats().get(Stats.SPEED) + "\n";
        playerStats += "Destreza: " + player.getStats().get(Stats.DEXTERITY) + "\n";
        playerStats += "Suerte: " + player.getStats().get(Stats.LUCK) + "\n";
        playerStats += "Precisión: " + player.getStats().get(Stats.ACCURACY) + "\n";
        playerStats += "Evasión: " + player.getStats().get(Stats.EVASION) + "\n";
        playerStats += "Probabilidad de golpe crítico: " + player.getStats().get(Stats.CRITICAL_HIT_CHANCE) + "\n";
        playerStats += "Daño de golpe crítico: " + player.getStats().get(Stats.CRITICAL_HIT_DAMAGE) + "\n";

        JOptionPane.showMessageDialog(null, playerStats, "Estadísticas del jugador", JOptionPane.INFORMATION_MESSAGE);

        // Mostrar estadísticas del enemigo
        String enemyStats = "Estadísticas del enemigo:\n";
        enemyStats += "Nombre: " + enemy.getName() + "\n";
        enemyStats += "HP: " + enemy.getStats().get(Stats.HP) + "/" + enemy.getStats().get(Stats.MAX_HP) + "\n";
        enemyStats += "MP: " + enemy.getStats().get(Stats.MP) + "/" + enemy.getStats().get(Stats.MAX_MP) + "\n";
        enemyStats += "Ataque: " + enemy.getStats().get(Stats.ATTACK) + "\n";
        enemyStats += "Defensa: " + enemy.getStats().get(Stats.DEFENSE) + "\n";
        enemyStats += "Velocidad: " + enemy.getStats().get(Stats.SPEED) + "\n";
        enemyStats += "Destreza: " + enemy.getStats().get(Stats.DEXTERITY) + "\n";
        enemyStats += "Suerte: " + enemy.getStats().get(Stats.LUCK) + "\n";
        enemyStats += "Precisión: " + enemy.getStats().get(Stats.ACCURACY) + "\n";
        enemyStats += "Evasión: " + enemy.getStats().get(Stats.EVASION) + "\n";
        enemyStats += "Probabilidad de golpe crítico: " + enemy.getStats().get(Stats.CRITICAL_HIT_CHANCE) + "\n";
        enemyStats += "Daño de golpe crítico: " + enemy.getStats().get(Stats.CRITICAL_HIT_DAMAGE) + "\n";

        JOptionPane.showMessageDialog(null, enemyStats, "Estadísticas del enemigo", JOptionPane.INFORMATION_MESSAGE);

        while (player.isAlive() && enemy.isAlive()) {
            // Turno del jugador
            player.attack(enemy);
            mostrarMensajeBatalla(player, enemy, true);
            if (!enemy.isAlive()) {
                break;
            }

            // Turno del enemigo
            enemy.attack(player);
            mostrarMensajeBatalla(player, enemy, false);
            if (!player.isAlive()) {
                break;
            }
        }

        if (player.isAlive()) {
            JOptionPane.showMessageDialog(null, player.getName() + " ha ganado la batalla!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, enemy.getName() + " ha ganado la batalla!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void mostrarMensajeBatalla(Player player, Enemy enemy, boolean esTurnoDelJugador) {
        String mensaje = "";
        if (esTurnoDelJugador) {
            mensaje += player.getName() + " atacó a " + enemy.getName() + " por " + (player.getStats().get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE)) + " de daño.\n";
        } else {
            mensaje += enemy.getName() + " atacó a " + player.getName() + " por " + (enemy.getStats().get(Stats.ATTACK) - player.getStats().get(Stats.DEFENSE)) + " de daño.\n";
        }
        mensaje += "Vida restante de " + player.getName() + ": " + player.getStats().get(Stats.HP) + "\n";
        mensaje += "Vida restante de " + enemy.getName() + ": " + enemy.getStats().get(Stats.HP) + "\n";
        JOptionPane.showMessageDialog(null, mensaje, "Batalla", JOptionPane.INFORMATION_MESSAGE);
    }



    public static void main(String[] args) {
        /*
        Obtener los datos del jugador
         */
        String playerName = JOptionPane.showInputDialog("Ingrese el nombre del jugador: ");
        int playerHP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese HP del jugador: "));
        int playerMaxHP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese HP Máximo del jugador: "));
        int playerMP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese MP del jugador: "));
        int playerMaxMP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese MP Máximo del jugador: "));
        int playerAttack = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Ataque del jugador: "));
        int playerDefense = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Defensa del jugador: "));
        int playerSpeed = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Velocidad del jugador: "));
        int playerDexterity = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Destreza del jugador: "));
        int playerLuck = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Suerte del jugador: "));
        int playerAccuracy = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Precisión del jugador: "));
        int playerEvasion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Evasión del jugador: "));
        int playerCriticalHitChance = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Probabilidad de Golpe Crítico del jugador: "));
        int playerCriticalHitDamage = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Daño de Golpe Crítico del jugador: "));

        /*
        Obtener los datos del enemigo
         */
        String enemyName = JOptionPane .showInputDialog("Ingrese el nombre del enemigo: ");
        int enemyHP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese HP del enemigo: "));
        int enemyMaxHP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese HP Máximo del enemigo: "));
        int enemyMP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese MP del enemigo: "));
        int enemyMaxMP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese MP Máximo del enemigo: "));
        int enemyAttack = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Ataque del enemigo: "));
        int enemyDefense = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Defensa del enemigo: "));
        int enemySpeed = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Velocidad del enemigo: "));
        int enemyDexterity = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Destreza del enemigo: "));
        int enemyLuck = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Suerte del enemigo: "));
        int enemyAccuracy = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Precisión del enemigo: "));
        int enemyEvasion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Evasión del enemigo: "));
        int enemyCriticalHitChance = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Probabilidad de Golpe Crítico del enemigo: "));
        int enemyCriticalHitDamage = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Daño de Golpe Crítico del enemigo: "));

        Map<Stats, Integer> playerStats = new HashMap<>();
        playerStats.put(Stats.HP, playerHP);
        playerStats.put(Stats.MAX_HP, playerMaxHP);
        playerStats.put(Stats.MP, playerMP);
        playerStats.put(Stats.MAX_MP, playerMaxMP);
        playerStats.put(Stats.ATTACK, playerAttack);
        playerStats.put(Stats.DEFENSE, playerDefense);
        playerStats.put(Stats.SPEED, playerSpeed);
        playerStats.put(Stats.DEXTERITY, playerDexterity);
        playerStats.put(Stats.LUCK, playerLuck);
        playerStats.put(Stats.ACCURACY, playerAccuracy);
        playerStats.put(Stats.EVASION, playerEvasion);
        playerStats.put(Stats.CRITICAL_HIT_CHANCE, playerCriticalHitChance);
        playerStats.put(Stats.CRITICAL_HIT_DAMAGE, playerCriticalHitDamage);

        Map<Stats, Integer> enemyStats = new HashMap<>();
        enemyStats.put(Stats.HP, enemyHP);
        enemyStats.put(Stats.MAX_HP, enemyMaxHP);
        enemyStats.put(Stats.MP, enemyMP);
        enemyStats.put(Stats.MAX_MP, enemyMaxMP);
        enemyStats.put(Stats.ATTACK, enemyAttack);
        enemyStats.put(Stats.DEFENSE, enemyDefense);
        enemyStats.put(Stats.SPEED, enemySpeed);
        enemyStats.put(Stats.DEXTERITY, enemyDexterity);
        enemyStats.put(Stats.LUCK, enemyLuck);
        enemyStats.put(Stats.ACCURACY, enemyAccuracy);
        enemyStats.put(Stats.EVASION, enemyEvasion);
        enemyStats.put(Stats.CRITICAL_HIT_CHANCE, enemyCriticalHitChance);
        enemyStats.put(Stats.CRITICAL_HIT_DAMAGE, enemyCriticalHitDamage);

        Player player = new Player(playerName, playerStats);
        Enemy enemy = new Enemy(enemyName, enemyStats);

        Game game = new Game(player, enemy);
        game.startGame();
    }
}