package rpg.entities;


import rpg.entities.Enemy;
import rpg.entities.Player;
import rpg.enums.Stats;
import javax.swing.JOptionPane;
public class Game {
    private Player player;
    private Enemy enemy;


    public Game(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void startGame() {
        JOptionPane.showMessageDialog(null, "¡Bienvenido al juego de RPG!");
        JOptionPane.showMessageDialog(null, "El jugador " + player.getName() + " se enfrenta a " + enemy.getName());

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
            JOptionPane.showMessageDialog(null, player.getName() + " ha ganado la batalla!");
        } else {
            JOptionPane.showMessageDialog(null, enemy.getName() + " ha ganado la batalla!");
        }
    }

    public static void main(String[] args) {
        // Obtener los datos del jugador
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

        // Obtener los datos del enemigo
        String enemyName = JOptionPane.showInputDialog("Ingrese el nombre del enemigo: ");
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


        Player player = new Player(playerName);
        Enemy enemy = new Enemy(enemyName);

        //Mostrar los datos del jugador en una ventana JOption
        String playerData = "Nombre: " + player.getName() + "\n";
        playerData += "HP: " + player.getStats().get(Stats.HP) + "/" + player.getStats().get(Stats.MAX_HP) + "\n";
        playerData += "MP: " + player.getStats().get(Stats.MP) + "/" + player.getStats().get(Stats.MAX_MP) + "\n";
        playerData += "Ataque: " + player.getStats().get(Stats.ATTACK) + "\n";
        playerData += "Defensa: " + player.getStats().get(Stats.DEFENSE) + "\n";
        playerData += "Velocidad: " + player.getStats().get(Stats.SPEED) + "\n";
        playerData += "Destreza: " + player.getStats().get(Stats.DEXTERITY) + "\n";
        playerData += "Suerte: " + player.getStats().get(Stats.LUCK) + "\n";
        playerData += "Precisión: " + player.getStats().get(Stats.ACCURACY) + "\n";
        playerData += "Evasión: " + player.getStats().get(Stats.EVASION) + "\n";
        playerData += "Probabilidad de Golpe Crítico: " + player.getStats().get(Stats.CRITICAL_HIT_CHANCE) + "\n";
        playerData += "Daño de Golpe Crítico: " + player.getStats().get(Stats.CRITICAL_HIT_DAMAGE) + "\n";
        JOptionPane.showMessageDialog(null, playerData, "Datos del Jugador", JOptionPane.INFORMATION_MESSAGE);

        //Mostrar los datos del enemigo en una ventana JOption
        String enemyData = "Nombre: " + enemy.getName() + "\n";
        enemyData += "HP: " + enemy.getStats().get(Stats.HP) + "/" + enemy.getStats().get(Stats.MAX_HP) + "\n";
        enemyData += "MP: " + enemy.getStats().get(Stats.MP) + "/" + enemy.getStats().get(Stats.MAX_MP) + "\n";
        enemyData += "Ataque: " + enemy.getStats().get(Stats.ATTACK) + "\n";
        enemyData += "Defensa: " + enemy.getStats().get(Stats.DEFENSE) + "\n";
        enemyData += "Velocidad: " + enemy.getStats().get(Stats.SPEED) + "\n";
        enemyData += "Destreza: " + enemy.getStats().get(Stats.DEXTERITY) + "\n";
        enemyData += "Suerte: " + enemy.getStats().get(Stats.LUCK) + "\n";
        enemyData += "Precisión: " + enemy.getStats().get(Stats.ACCURACY) + "\n";
        enemyData += "Evasión: " + enemy.getStats().get(Stats.EVASION) + "\n";
        enemyData += "Probabilidad de Golpe Crítico: " + enemy.getStats().get(Stats.CRITICAL_HIT_CHANCE) + "\n";
        enemyData += "Daño de Golpe Crítico: " + enemy.getStats().get(Stats.CRITICAL_HIT_DAMAGE) + "\n";
        JOptionPane.showMessageDialog(null, enemyData, "Datos del Enemigo", JOptionPane.INFORMATION_MESSAGE);

        //Settear los stats del jugador y el enemigo
        player.getStats().put(Stats.HP, playerHP);
        player.getStats().put(Stats.MAX_HP, playerMaxHP);
        player.getStats().put(Stats.MP, playerMP);
        player.getStats().put(Stats.MAX_MP, playerMaxMP);
        player.getStats().put(Stats.ATTACK, playerAttack);
        player.getStats().put(Stats.DEFENSE, playerDefense);
        player.getStats().put(Stats.SPEED, playerSpeed);
        player.getStats().put(Stats.DEXTERITY, playerDexterity);
        player.getStats().put(Stats.LUCK, playerLuck);
        player.getStats().put(Stats.ACCURACY, playerAccuracy);
        player.getStats().put(Stats.EVASION, playerEvasion);
        player.getStats().put(Stats.CRITICAL_HIT_CHANCE, playerCriticalHitChance);
        player.getStats().put(Stats.CRITICAL_HIT_DAMAGE, playerCriticalHitDamage);

        enemy.getStats().put(Stats.HP, enemyHP);
        enemy.getStats().put(Stats.MAX_HP, enemyMaxHP);
        enemy.getStats().put(Stats.MP, enemyMP);
        enemy.getStats().put(Stats.MAX_MP, enemyMaxMP);
        enemy.getStats().put(Stats.ATTACK, enemyAttack);
        enemy.getStats().put(Stats.DEFENSE, enemyDefense);
        enemy.getStats().put(Stats.SPEED, enemySpeed);
        enemy.getStats().put(Stats.DEXTERITY, enemyDexterity);
        enemy.getStats().put(Stats.LUCK, enemyLuck);
        enemy.getStats().put(Stats.ACCURACY, enemyAccuracy);
        enemy.getStats().put(Stats.EVASION, enemyEvasion);
        enemy.getStats().put(Stats.CRITICAL_HIT_CHANCE, enemyCriticalHitChance);
        enemy.getStats().put(Stats.CRITICAL_HIT_DAMAGE, enemyCriticalHitDamage);

        //Comenzar el juego con los stats seteados
        Game game = new Game(player, enemy);
        game.startGame();
    }
}