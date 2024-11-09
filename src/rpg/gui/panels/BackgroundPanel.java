package rpg.gui.panels;

import javax.swing.*;
import java.awt.*;

public abstract class BackgroundPanel extends JPanel {
    protected Image backgroundImage;
    protected Dimension dimension;

    public BackgroundPanel(Dimension dimension) {
        this.dimension = dimension;
        setDimension(dimension);
        init();
    }

    protected abstract void init();

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    protected void setBackgroundImage(ImageIcon imageIcon) {
        if (imageIcon != null) {
            this.backgroundImage = imageIcon.getImage();
            repaint();
        }
    }
}


