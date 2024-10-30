package rpg.gui.panels;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public abstract class BackgroundPanel extends JPanel {
    protected ImageIcon backgroundImage;
    protected Dimension dimension;

    public BackgroundPanel() {
        init();
    }

    protected abstract void init();

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawImage(backgroundImage.getImage(), 0, 0, dimension.width, dimension.height, null);
    }
}
