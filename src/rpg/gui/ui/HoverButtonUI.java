// Archivo: HoverButtonUI.java
package rpg.gui.ui;

import rpg.utils.cache.ImageCache;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import rpg.utils.cache.FontCache;
public class HoverButtonUI extends BasicButtonUI {
    protected int width;
    protected int height;
    protected ImageIcon[] parts;
    protected ImageIcon[] partsHover;
    private static final int MAX_BUTTON_WIDTH = 130; // Ajusta este valor para cambiar el ancho máximo

    @Override
    protected void installDefaults(AbstractButton b) {
        initParts(b);
        b.setFont(new Font("Pixeled", Font.PLAIN, 7)); // Tamaño de fuente Arial 11
        b.setForeground(Color.BLACK);
        b.setDoubleBuffered(true);
        b.setOpaque(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);
        b.setIconTextGap(5);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));

        String text = b.getText();
        this.width = b.getFontMetrics(b.getFont()).stringWidth(text) + 8;
        this.height = Math.max(parts[1].getIconHeight(), 28);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        // Aplicar un límite máximo al ancho del botón
        int totalWidth = Math.max(width + parts[0].getIconWidth() + parts[2].getIconWidth(), 60);
        return new Dimension(Math.min(totalWidth, MAX_BUTTON_WIDTH), height);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        Graphics2D g2d = (Graphics2D) g;
        AbstractButton button = (AbstractButton) c;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        ImageIcon[] images = button.getModel().isRollover() ? partsHover : parts;
        drawButtonParts(g2d, images, button.getWidth(), button.getHeight());

        FontMetrics fm = button.getFontMetrics(button.getFont());
        String text = button.getText();
        int textX = (button.getWidth() - fm.stringWidth(text)) / 2;
        int textY = (button.getHeight() + fm.getAscent() - fm.getDescent()) / 2;

        g2d.setColor(button.getForeground());
        g2d.drawString(text, textX, textY);
    }

    protected void initParts(AbstractButton b) {
        parts = new ImageIcon[3];
        partsHover = new ImageIcon[3];
        ImageCache.addImage("userLeftSide", "boton1left.png");
        ImageCache.addImage("userCenterSide", "boton1center.png");
        ImageCache.addImage("userRightSide", "boton1right.png");
        ImageCache.addImage("userHoverLeftSide", "boton1leftefecto.png");
        ImageCache.addImage("userHoverCenterSide", "boton1centerefecto.png");
        ImageCache.addImage("userHoverRightSide", "boton1rightefecto.png");

        int buttonHeight = 36;
        int buttonWidth = Math.max(b.getFontMetrics(b.getFont()).stringWidth(b.getText()) + 16, 60);

        parts[0] = scaleImage(ImageCache.getImageIcon("userLeftSide"), -1, buttonHeight);
        parts[1] = scaleImage(ImageCache.getImageIcon("userCenterSide"), buttonWidth, buttonHeight);
        parts[2] = scaleImage(ImageCache.getImageIcon("userRightSide"), -1, buttonHeight);

        partsHover[0] = scaleImage(ImageCache.getImageIcon("userHoverLeftSide"), -1, buttonHeight);
        partsHover[1] = scaleImage(ImageCache.getImageIcon("userHoverCenterSide"), buttonWidth, buttonHeight);
        partsHover[2] = scaleImage(ImageCache.getImageIcon("userHoverRightSide"), -1, buttonHeight);
    }

    protected ImageIcon scaleImage(ImageIcon icon, int width, int height) {
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    protected void drawButtonParts(Graphics2D g2d, ImageIcon[] parts, int buttonWidth, int buttonHeight) {
        int leftWidth = parts[0].getIconWidth();
        int rightWidth = parts[2].getIconWidth();

        // Ajustar el ancho central considerando el límite máximo del botón
        int maxCenterWidth = Math.max(10, MAX_BUTTON_WIDTH - leftWidth - rightWidth);
        int centerWidth = Math.min(buttonWidth - leftWidth - rightWidth, maxCenterWidth);

        // Dibujamos la parte izquierda
        g2d.drawImage(parts[0].getImage(), 0, 0, leftWidth, buttonHeight, null);

        // Dibujamos la parte central con ajuste de ancho
        g2d.drawImage(parts[1].getImage(), leftWidth, 0, centerWidth, buttonHeight, null);

        // Dibujamos la parte derecha
        g2d.drawImage(parts[2].getImage(), leftWidth + centerWidth, 0, rightWidth, buttonHeight, null);
    }
}


