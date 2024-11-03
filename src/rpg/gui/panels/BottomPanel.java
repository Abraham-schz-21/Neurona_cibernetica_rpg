package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class BottomPanel extends BackgroundPanel {
    @Override
    protected void init() {
        backgroundImage = new ImageIcon(ImageCache.addImage("bottomPanel", "Imagen4.png"));
        setDimension(WindowConstants.BOTTOM_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);

    }
}