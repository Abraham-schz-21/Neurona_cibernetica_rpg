package rpg.gui;

import rpg.utils.cache.FontCache;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public interface UIConstants {
    Font FONT = FontCache.addFont("PIXM", "fonts/Pixeled.ttf");
    Font BAR_LABEL_FONT = FontCache.addFont("PAE", "fonts/Pixeled.ttf").deriveFont(12f);
    Dimension BAR_ICON = new Dimension(58, 58);
    Dimension BAR_DISPLAY = new Dimension(179, 58);
    Font LABEL_FONT = new Font("Pixeled", Font.PLAIN, 9);
    // Otras constantes...
}


