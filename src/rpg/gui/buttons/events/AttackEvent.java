package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.gui.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttackEvent implements ActionListener {

    private final MainWindow game;

    public AttackEvent(MainWindow game) {

        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Player player = game.getPlayer();
        Enemy enemy = game.getEnemy();

        if (enemy != null) {
            String attackMessage = player.attack(enemy);
            game.getBottomPanel().appendText(attackMessage); // Mostrar el ataque del jugador

            if (enemy.isAlive()) {
                String enemyAttackMessage = enemy.attack(player);
                game.getBottomPanel().appendText(enemyAttackMessage); // Mostrar el ataque del enemigo
            }

            game.checkGameStatus(); // Verificar el estado del juego
            updateUIAfterAttack(); // Método para actualizar las barras y el oro
        }
    }

    private void updateUIAfterAttack() {
        // Actualizar la barra de vida del enemigo
        game.getMiddlePanel().getEnemyLifeLabel().setBarValue(game.getEnemy().getStats().get(Stats.HP));

        // Actualizar el oro del jugador
        int goldDropped = game.getEnemy().getStats().get(Stats.GOLD);
        int currentGold = Integer.parseInt(game.getTopPanel().getGoldLabel().getText());
        game.getTopPanel().getGoldLabel().setText(String.valueOf(currentGold + goldDropped)); // Sumar el oro del enemigo

        // Actualizar la barra de experiencia del jugador
        int experienceGained = game.getEnemy().getStats().get(Stats.EXPERIENCE);
        int currentExp = game.getTopPanel().getExpLabel().getBarValue();
        game.getTopPanel().getExpLabel().setBarValue(currentExp + experienceGained);

        // Verificar si el jugador sube de nivel
        if (currentExp + experienceGained >= game.getPlayer().getStats().get(Stats.NEEDED_EXPERIENCE)) {
            game.getPlayer().levelUp(); // Método para subir de nivel
            game.getTopPanel().getExpLabel().setBarValue(0); // Reiniciar experiencia
            // Actualizar el nombre del jugador con el nuevo nivel
            game.getTopPanel().getNameLabel().setText("ZEUS LVL. " + game.getPlayer().getStats().get(Stats.LEVEL));
        }
    }
}
