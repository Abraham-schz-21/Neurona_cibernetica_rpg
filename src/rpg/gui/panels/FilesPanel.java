package rpg.gui.panels;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class FilesPanel extends BackgroundPanel {

    public FilesPanel() {
        super(new Dimension(600, 300)); // Tamaño de la ventana
        setBackgroundImage(new ImageIcon(ImageCache.addImage("filesPanelBackground", "Imagen4.png"))); // Cambia el nombre de la imagen según sea necesario
    }

    @Override
    protected void init() {
        // Puedes agregar inicializaciones adicionales si es necesario
    }
}