package rpg.gui.panels;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.gui.MainWindow;
import rpg.gui.UIConstants;
import rpg.gui.buttons.*;
import rpg.gui.WindowConstants;
import rpg.gui.buttons.events.AttackEvent;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends BackgroundPanel {

    private JTextArea textDisplay; // Área de texto para mostrar mensajes
    private JScrollPane textScroll; // ScrollPane para el JTextArea
    private JButton attackButton;
    private MainWindow game;

    public BottomPanel(MainWindow game) {
        super(WindowConstants.BOTTOM_DIMENSION);
        initComponents();// Inicializar componentes
    }

    private void initComponents() {

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
        section2.setPreferredSize(new Dimension(840, 244));

        // Hacer transparentes las secciones para mostrar la imagen de fondo
        section1.setOpaque(false);
        section2.setOpaque(false);

        // Usar BoxLayout para colocar los botones en una columna
        section1.setLayout(new BoxLayout(section1, BoxLayout.Y_AXIS));

        // Configurar márgenes de sección1 para desplazar los botones
        section1.setBorder(BorderFactory.createEmptyBorder(30, 30, 50, 50));  // margen superior e izquierdo
        section2.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        // Crear los botones
        AttackButton attackButton = new AttackButton();
        FleeButton fleeButton = new FleeButton();
        SkillsButton skillsButton = new SkillsButton();
        StatsButton statsButton = new StatsButton();

        attackButton.addActionListener(new AttackEvent(game));

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

        // Inicializar el área de mensajes
        initMessageArea(section2);

        // Agregar las secciones al panel
        JPanel bottomPanelSections = new JPanel();
        bottomPanelSections.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        bottomPanelSections.add(section1);
        bottomPanelSections.add(section2);

        // Hacer transparente el contenedor de las secciones
        bottomPanelSections.setOpaque(false);

        add(bottomPanelSections, BorderLayout.CENTER);
    }

    private void initMessageArea(JPanel section2) {
        // Crear el JTextArea
        textDisplay = new JTextArea();
        textDisplay.setFont(UIConstants.FONT.deriveFont(10f));
        textDisplay.setBackground(Color.GRAY); // Color de fondo negro
        textDisplay.setForeground(Color.BLACK);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
        textDisplay.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Crear el JScrollPane y añadir el JTextArea
        textScroll = new JScrollPane(textDisplay);
        textScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textScroll.getViewport().setOpaque(true); // Hacer el viewport transparente

        // Cambiar el color de fondo del JViewport
        textScroll.getViewport().setBackground(Color.CYAN); // Cambia a cualquier color que desees


        // Añadir el JScrollPane a la sección 2

        section2.setLayout(new BorderLayout());
        section2.add(textScroll, BorderLayout.CENTER);
        section2.setOpaque(false); // Hacer la sección transparente

    }

    // Método para agregar texto al JTextArea y desplazar el scroll al final
    public void appendText(String text) {
        textDisplay.append(text + "\n");
        textDisplay.setCaretPosition(textDisplay.getDocument().getLength());
    }
}

