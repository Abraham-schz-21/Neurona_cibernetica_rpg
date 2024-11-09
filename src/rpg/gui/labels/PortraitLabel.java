package rpg.gui.labels;

import rpg.gui.ui.LabelUI;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class PortraitLabel extends JLabel {

    protected ImageIcon icon;

    public PortraitLabel() {
        initComponents();
        setUI(new LabelUI(getPreferredSize(), icon));
    }

    public void initComponents() {
        ImageCache.addImage("portrait", "portrait.png");
        icon = ImageCache.getImageIcon("portrait");
        setPreferredSize(new Dimension(120, 120));  // Dimensiones fijas de 120x120
        setIcon(icon);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Escalar la imagen al tamaño deseado
        Image scaledImage = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        g2d.drawImage(scaledImage, 0, 0, this);
    }
}