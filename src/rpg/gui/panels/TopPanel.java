package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.gui.buttons.*;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends BackgroundPanel {

    public TopPanel() {
        super(WindowConstants.TOP_DIMENSION);
    }

    @Override
    protected void init() {
        setLayout(new BorderLayout());

        // Establecer la imagen de fondo
        setBackgroundImage(new ImageIcon(ImageCache.addImage("topPanel", "Imagen5.png")));

        // Crear las secciones y hacerlas transparentes
        JPanel section1 = new JPanel();
        JPanel section2 = new JPanel();
        JPanel section3 = new JPanel();

        section1.setPreferredSize(new Dimension(100, 100));
        section2.setPreferredSize(new Dimension(770, 100));
        section3.setPreferredSize(new Dimension(364, 115));

        // Hacer transparentes las secciones para mostrar la imagen de fondo
        section1.setOpaque(false);
        section2.setOpaque(false);
        section3.setOpaque(false);

        // Agregar botones a la tercera sección
        section3.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 7));
        InventoryButton inventoryButton = new InventoryButton();
        ShopButton shopButton = new ShopButton();
        BlacksmithButton blacksmithButton = new BlacksmithButton();
        SaveButton saveButton = new SaveButton();
        ExitButton exitButton = new ExitButton();

        section3.add(inventoryButton);
        section3.add(shopButton);
        section3.add(blacksmithButton);
        section3.add(saveButton);
        section3.add(exitButton);

        // Agregar las secciones al panel
        JPanel topPanelSections = new JPanel();
        topPanelSections.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        topPanelSections.add(section1);
        topPanelSections.add(section2);
        topPanelSections.add(section3);

        // Hacer transparente el contenedor de las secciones
        topPanelSections.setOpaque(false);

        add(topPanelSections, BorderLayout.CENTER);
    }
}

