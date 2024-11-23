package rpg.gui.panels;
import rpg.enums.Stats;
import rpg.gui.labels.PlayerSpriteLabel;
import rpg.gui.labels.EnemySpriteLabel;
import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.basic.Harpy; // Ejemplo de enemigo
import rpg.gui.labels.NameLabel;
import rpg.gui.labels.BarLabel;
import rpg.enums.BarType;
import rpg.gui.WindowConstants;
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

        // Panel derecho para el sprite del enemigo
        JPanel enemyPanel = new JPanel();
        enemyPanel.setLayout(new BorderLayout());
        enemyPanel.setOpaque(false); // Hacer transparente

        Enemy enemy = new Harpy(); // Crear un enemigo (puedes cambiar esto)
        enemySpriteLabel = new EnemySpriteLabel(enemy);
        enemyNameLabel = new NameLabel(enemy.getName());
        enemyLifeLabel = new BarLabel(enemy.getStats().get(Stats.HP), enemy.getStats().get(Stats.MAX_HP), BarType.LIFE);

        JPanel enemyInfoPanel = new JPanel();
        enemyInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        enemyInfoPanel.setOpaque(false); // Hacer transparente
        enemyInfoPanel.add(enemyNameLabel);
        enemyInfoPanel.add(enemyLifeLabel);

        enemyPanel.add(enemySpriteLabel, BorderLayout.SOUTH); // Centrar en la parte inferior
        enemyPanel.add(enemyInfoPanel, BorderLayout.CENTER); // Agregar información del enemigo

        // Agregar los paneles al panel central
        add(playerPanel);
        add(enemyPanel);
    }

    @Override
    protected void init() {

    }
}

