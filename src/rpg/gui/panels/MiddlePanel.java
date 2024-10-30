package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class MiddlePanel extends BackgroundPanel {
    @Override
    protected void init() {
        backgroundImage = new ImageIcon(ImageCache.addImage("MidPanel", "Imagen2.png"));
        setDimension(WindowConstants.MIDDLE_DIMENSION);
    }
}