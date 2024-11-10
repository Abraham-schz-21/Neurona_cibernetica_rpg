package rpg.gui;

import rpg.utils.cache.FontCache;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public interface UIConstants {
    Font FONT = FontCache.addFont("PIXM", "fonts/M6 Bold.ttf");
    Font BAR_LABEL_FONT = FontCache.addFont("PAE", "fonts/DePixelBreitFett.ttf").deriveFont(16f);
    Dimension BAR_ICON = new Dimension(58, 58);
    Dimension BAR_DISPLAY = new Dimension(179, 58);
    // Otras constantes...
}


