package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class MiddlePanel extends BackgroundPanel {
    public MiddlePanel() {
        super(WindowConstants.MIDDLE_DIMENSION);
    }

    @Override
    protected void init() {
        // Obtén la imagen usando el ImageCache y asegúrate de convertirla a java.awt.Image
        setBackgroundImage(new ImageIcon(ImageCache.addImage("MidPanel", "Imagen8.png")));
    }
}

