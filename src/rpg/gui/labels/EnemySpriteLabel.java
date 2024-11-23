package rpg.gui.labels;

import rpg.entities.enemies.Enemy;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class EnemySpriteLabel extends JLabel {
    private ImageIcon icon;
    private Enemy enemy;

    public EnemySpriteLabel(Enemy enemy) {
        this.enemy = enemy;
        initComponents();
    }

    public void initComponents() {
        icon = enemy.getSprite();
        setPreferredSize(new Dimension(200, 220));
        setIcon(icon);
        setOpaque(false);
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
        icon = enemy.getSprite();
        setIcon(icon);
    }
}
