package rpg.gui.ui;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class NameLabelUI extends BasicLabelUI {

    private final BufferedImage[] icons;

    public NameLabelUI() {
        icons = new BufferedImage[3];
        ImageCache.addImage("name_l", "name_label_left.png");
        ImageCache.addImage("name_c", "name_label_center.png");
        ImageCache.addImage("name_r", "name_label_right.png");
        icons[0] = ImageCache.getImage("name_l");
        icons[1] = ImageCache.getImage("name_c");
        icons[2] = ImageCache.getImage("name_r");
    }

    @Override
    protected void installDefaults(JLabel c) {
        c.setFont(new Font("Pixeled", Font.PLAIN, 10));
        c.setForeground(Color.WHITE);
        c.setVerticalAlignment(JLabel.CENTER);
        c.setHorizontalAlignment(JLabel.CENTER);
        c.setPreferredSize(new Dimension(150, 40)); // Tamaño de la etiqueta
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        JLabel label = (JLabel) c;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja las imágenes de la etiqueta
        g2d.drawImage(icons[0], 0, 0, null);
        g2d.drawImage(icons[1], icons[0].getWidth(), 0, label.getWidth() - icons[0].getWidth() - icons[2].getWidth(), icons[1].getHeight(), null);
        g2d.drawImage(icons[2], label.getWidth() - icons[2].getWidth(), 0, null);

        // Calcular la posición del texto
        FontMetrics fm = g.getFontMetrics();
        int textX = (label.getWidth() - fm.stringWidth(label.getText())) / 2;
        int textY = (label.getHeight() + fm.getAscent()) / 2;

        // Dibuja el texto centrado
        g2d.drawString(label.getText(), textX, textY);
    }
}
