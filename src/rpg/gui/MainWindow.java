package rpg.gui;

import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

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
        // Inicializamos el DesktopPane
        desktopPane = new JDesktopPane();

        // Inicializamos el mainPanel con un layout vertical
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Inicializamos los paneles
        createUIComponents();

        // Agregamos colores de fondo temporales para verificar que se están mostrando
        topPanel.setBackground(Color.RED);
        middlePanel.setBackground(Color.GREEN);
        bottomPanel.setBackground(Color.BLUE);

        // Agregamos los paneles al mainPanel
        mainPanel.add(topPanel);
        mainPanel.add(middlePanel);
        mainPanel.add(bottomPanel);

        // Agregamos el mainPanel al DesktopPane y lo ajustamos al BorderLayout.CENTER
        desktopPane.setLayout(new BorderLayout());
        desktopPane.add(mainPanel, BorderLayout.CENTER);

        // Configuraciones de la ventana
        setContentPane(desktopPane);
        setTitle("RPG Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(WindowConstants.WINDOW_SIZE)); // Asegura que la ventana sea visible
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true); // Mostrar la ventana
        setResizable(false);
    }

    private void createUIComponents() {
        // Creamos el contenido personalizado de la ventana
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}



