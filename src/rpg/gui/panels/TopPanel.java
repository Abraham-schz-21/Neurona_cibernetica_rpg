package rpg.gui.panels;

import rpg.gui.buttons.*;
import rpg.gui.labels.PortraitLabel;
import rpg.gui.labels.BarLabel;
import rpg.gui.labels.NameLabel;
import rpg.gui.labels.GoldLabel;
import rpg.enums.BarType;
import rpg.utils.cache.ImageCache;
import rpg.gui.WindowConstants;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends BackgroundPanel {

    private BarLabel lifeLabel;
    private BarLabel magicLabel;
    private BarLabel expLabel;
    private GoldLabel goldLabel;
    private NameLabel nameLabel;
    public TopPanel() {
        super(WindowConstants.TOP_DIMENSION);
        init();
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

        section1.setPreferredSize(new Dimension(120, 130));
        section2.setPreferredSize(new Dimension(765, 120));
        section3.setPreferredSize(new Dimension(364, 115));

        // Hacer transparentes las secciones para mostrar la imagen de fondo
        section1.setOpaque(false);
        section2.setOpaque(false);
        section3.setOpaque(false);

        // Crear el retrato del personaje
        PortraitLabel portraitLabel = new PortraitLabel();
        section1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        section1.add(portraitLabel); // Añadir el retrato a la sección 1

        // Crear las barras de estado
        BarLabel lifeLabel = new BarLabel(100, 100, BarType.LIFE);
        BarLabel magicLabel = new BarLabel(0, 100, BarType.MAGIC);
        BarLabel expLabel = new BarLabel(0, 350, BarType.EXPERIENCE);

        // Añadir las barras de estado a la sección 2
        section2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        section2.add(lifeLabel);
        section2.add(magicLabel);
        section2.add(expLabel);

        // Crear etiquetas para el nombre y el dinero
        NameLabel nameLabel = new NameLabel("ZEUS LVL. 1");
        GoldLabel goldLabel = new GoldLabel();

        // Crear un panel para las etiquetas
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5)); // Alinear a la izquierda
        labelPanel.setPreferredSize(new Dimension(314, 50)); // Tamaño de la sección de etiquetas
        labelPanel.setOpaque(false); // Hacerlo transparente

        // Añadir las etiquetas al panel
        labelPanel.add(nameLabel);
        labelPanel.add(goldLabel);

        // Añadir el panel de etiquetas a la sección 2
        section2.add(labelPanel);

        // Agregar botones a la tercera sección
        section3.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 0));
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
        topPanelSections.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        topPanelSections.add(section1);
        topPanelSections.add(section2);
        topPanelSections.add(section3);

        // Hacer transparente el contenedor de las secciones
        topPanelSections.setOpaque(false);

        add(topPanelSections, BorderLayout.CENTER);
    }

    public BarLabel getLifeLabel() {
        return lifeLabel;
    }

    public BarLabel getMagicLabel() {
        return magicLabel;
    }

    public BarLabel getExpLabel() {
        return expLabel;
    }

    public GoldLabel getGoldLabel() {
        return goldLabel;
    }

    public NameLabel getNameLabel() { // Método para obtener el NameLabel
        return nameLabel;
    }
}
