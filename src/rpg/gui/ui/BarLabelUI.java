package rpg.gui.ui;

import rpg.enums.BarType;
import rpg.gui.labels.BarLabel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BarLabelUI extends BasicLabelUI {
    private final BarType type;

    public BarLabelUI(BarType type) {
        this.type = type;
    }

    @Override
    protected void installDefaults(JLabel c) {
        c.setOpaque(false);
        c.setBorder(null);
        c.setForeground(Color.WHITE);
        c.setFont(new Font("Arial", Font.PLAIN, 14)); // Ajusta el tamaño de la fuente
        c.setVerticalAlignment(JLabel.BOTTOM);
        c.setHorizontalAlignment(JLabel.LEFT);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(210, 60); // Tamaño total de la barra
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        BarLabel barLabel = (BarLabel) c;
        BufferedImage icon = type.getIcon();
        BufferedImage container = type.getContainer();
        BufferedImage bar = type.getBar();
        int barValue = barLabel.getBarValue();
        int maxValue = barLabel.getMaxValue();
        int barWidth = (int) ((double) barValue / maxValue * 163); // Ancho de la barra
        int barHeight = 26; // Altura de la barra

        // Dibuja el contenedor
        g2d.drawImage(container, 36, 0, 174, 60, null); // Cargado hacia el lado derecho

        // Dibuja el icono en la parte superior izquierda
        g2d.drawImage(icon, 0, 0, 40, 40, null); // Ajusta la posición del icono

        // Dibuja la barra centrada en la parte superior del contenedor
        g2d.drawImage(bar, 45, 5, barWidth, barHeight, null); // Ajusta la posición de la barra

        // Dibuja el texto en la parte inferior izquierda
        String text = String.format("%d / %d", barValue, maxValue);
        g2d.setColor(Color.WHITE);
        g2d.drawString(text, 45, 55); // Ajusta la posición del texto

        super.paint(g, c);
    }
}