package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class TopPanel extends BackgroundPanel {
    @Override
    protected void init() {
        backgroundImage = new ImageIcon(ImageCache.addImage("topPanel", "Imagen1.png"));
        setDimension(WindowConstants.TOP_DIMENSION);
    }
}