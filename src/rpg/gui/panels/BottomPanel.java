package rpg.gui.panels;

import rpg.gui.buttons.*;
import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends BackgroundPanel {

    public BottomPanel() {
        super(WindowConstants.BOTTOM_DIMENSION);
    }

    @Override
    protected void init() {
        setLayout(new BorderLayout());

        // Establecer la imagen de fondo
        setBackgroundImage(new ImageIcon(ImageCache.addImage("bottomPanel", "Imagen4.png")));

        // Crear las secciones y hacerlas transparentes
        JPanel section1 = new JPanel();
        JPanel section2 = new JPanel();

        section1.setPreferredSize(new Dimension(400, 274));
        section2.setPreferredSize(new Dimension(840, 274));

        // Hacer transparentes las secciones para mostrar la imagen de fondo
        section1.setOpaque(false);
        section2.setOpaque(false);

        // Usar BoxLayout para colocar los botones en una columna
        section1.setLayout(new BoxLayout(section1, BoxLayout.Y_AXIS));

        // Configurar márgenes de sección1 para desplazar los botones
        section1.setBorder(BorderFactory.createEmptyBorder(30, 30, 50, 50));  // margen superior e izquierdo

        // Crear los botones
        AttackButton attackButton = new AttackButton();
        FleeButton fleeButton = new FleeButton();
        SkillsButton skillsButton = new SkillsButton();
        StatsButton statsButton = new StatsButton();

        // Asegurarse de que los botones no se estiren ni deformen
        attackButton.setMaximumSize(attackButton.getPreferredSize());
        fleeButton.setMaximumSize(fleeButton.getPreferredSize());
        skillsButton.setMaximumSize(skillsButton.getPreferredSize());
        statsButton.setMaximumSize(statsButton.getPreferredSize());

        // Añadir más espaciado entre botones utilizando un Espaciador (Box.createVerticalStrut)
        section1.add(attackButton);
        section1.add(Box.createVerticalStrut(20));  // Espacio entre los botones
        section1.add(fleeButton);
        section1.add(Box.createVerticalStrut(20));  // Espacio entre los botones
        section1.add(skillsButton);
        section1.add(Box.createVerticalStrut(20));  // Espacio entre los botones
        section1.add(statsButton);

        // Agregar las secciones al panel
        JPanel bottomPanelSections = new JPanel();
        bottomPanelSections.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        bottomPanelSections.add(section1);
        bottomPanelSections.add(section2);

        // Hacer transparente el contenedor de las secciones
        bottomPanelSections.setOpaque(false);

        add(bottomPanelSections, BorderLayout.CENTER);
    }
}

