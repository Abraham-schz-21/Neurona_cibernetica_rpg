package rpg.gui;

import rpg.entities.enemies.basic.Harpy;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;
import rpg.gui.windows.StartWindow;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JDesktopPane desktopPane;
    private TopPanel topPanel;
    private MiddlePanel middlePanel;
    private BottomPanel bottomPanel;
    private JPanel mainPanel;

    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        desktopPane = new JDesktopPane();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Inicializar los paneles usando las dimensiones de WindowConstants
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();

        // Agregar los paneles al mainPanel
        mainPanel.add(topPanel);
        mainPanel.add(middlePanel);
        mainPanel.add(bottomPanel);

        // Configurar el DesktopPane
        desktopPane.setLayout(new BorderLayout());
        desktopPane.add(mainPanel, BorderLayout.CENTER);

        // Configuración de la ventana
        setContentPane(desktopPane);
        setTitle("RPG Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WindowConstants.WINDOW_SIZE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void showStartWindow() {
        StartWindow startWindow = new StartWindow();
        startWindow.setVisible(true); // Muestra la ventana de carga de partida
    }

    public static void main(String[] args) {
        new MainWindow();
    }


}


