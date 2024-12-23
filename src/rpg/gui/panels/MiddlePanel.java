package rpg.gui.panels;
import rpg.entities.enemies.basic.Satyr;
import rpg.entities.enemies.finals.Hydra;
import rpg.entities.enemies.finals.Jellyfish;
import rpg.entities.enemies.medium.Cerberus;
import rpg.entities.enemies.medium.Minotaur;
import rpg.entities.enemies.secret.Cronos;
import rpg.entities.enemies.secret.Typhoon;
import rpg.enums.Stats;
import rpg.gui.labels.PlayerSpriteLabel;
import rpg.gui.labels.EnemySpriteLabel;
import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.basic.Harpy; // Ejemplo de enemigo
import rpg.gui.labels.NameLabel;
import rpg.gui.labels.BarLabel;
import rpg.enums.BarType;
import rpg.gui.WindowConstants;
import rpg.utils.Randomize;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class MiddlePanel extends BackgroundPanel {

    private PlayerSpriteLabel playerSpriteLabel;
    private EnemySpriteLabel enemySpriteLabel;
    private NameLabel enemyNameLabel;
    private BarLabel enemyLifeLabel;

    public MiddlePanel() {
        super(WindowConstants.MIDDLE_DIMENSION);
        initComponents();
    }


    private void initComponents() {
        // Obtén la imagen usando el ImageCache y asegúrate de convertirla a java.awt.Image
        setBackgroundImage(new ImageIcon(ImageCache.addImage("MidPanel", "Imagen8.png")));

        setLayout(new GridLayout(1, 2)); // Dividir en 2 columnas

        // Panel izquierdo para el sprite del jugador
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BorderLayout());
        playerPanel.setOpaque(false); // Hacer transparente

        playerSpriteLabel = new PlayerSpriteLabel();
        playerPanel.add(playerSpriteLabel, BorderLayout.SOUTH); // Centrar en la parte inferior
        playerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,90));

        // Panel derecho para el sprite del enemigo
        JPanel enemyPanel = new JPanel();
        enemyPanel.setLayout(new BorderLayout());
        enemyPanel.setOpaque(false); // Hacer transparente

        Enemy enemy = Randomize.getRandomEnemy();
         // Crear un enemigo (puedes cambiar esto)
        enemySpriteLabel = new EnemySpriteLabel(enemy);
        enemyNameLabel = new NameLabel(enemy.getName());
        enemyLifeLabel = new BarLabel(enemy.getStats().get(Stats.HP), enemy.getStats().get(Stats.MAX_HP), BarType.LIFE);

        JPanel enemyInfoPanel = new JPanel();
        enemyInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        enemyInfoPanel.setOpaque(false); // Hacer transparente
        enemyInfoPanel.add(enemyNameLabel);
        enemyInfoPanel.add(enemyLifeLabel);


        enemyPanel.add(enemySpriteLabel, BorderLayout.SOUTH); // Centrar en la parte inferior
        enemyPanel.add(enemyInfoPanel, BorderLayout.CENTER);// Agregar información del enemigo




        // Agregar los paneles al panel central
        add(playerPanel);
        add(enemyPanel);
    }
    public void setEnemy(Enemy enemy) {
        this.enemySpriteLabel.setEnemy(enemy);
        this.enemyLifeLabel.setBarValue(enemy.getStats().get(Stats.HP)); // Establecer vida inicial del enemigo
    }

    public BarLabel getEnemyLifeLabel() {
        return enemyLifeLabel;
    }

    @Override
    protected void init() {

    }
}

