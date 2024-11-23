package rpg.gui.labels;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class PlayerSpriteLabel extends JLabel {
    private ImageIcon icon;

    public PlayerSpriteLabel() {
        initComponents();
    }

    public void initComponents() {
        ImageCache.addImage("playerSprite", "player.png");
        icon = ImageCache.getImageIcon("playerSprite");
        setPreferredSize(new Dimension(200, 220));
        setIcon(icon);
        setOpaque(false);
    }

}
