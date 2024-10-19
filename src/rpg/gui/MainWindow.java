package rpg.gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel statusBar;
    private JPanel gamePanel;
    private JPanel actionBar;

    public MainWindow() {
        setTitle("RPG Game");
        setSize(WindowConstants.WINDOW_SIZE);  // Establecemos el tamaño de la ventana en 1280x720
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Usamos BoxLayout para organizar los paneles verticalmente
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));  // Orientación vertical

        // Crear la barra de estado (status bar)
        statusBar = new JPanel();
        statusBar.setBackground(Color.CYAN);
        statusBar.setPreferredSize(new Dimension(WindowConstants.WINDOW_SIZE.width, 120));  // Tamaño fijo de 1280x120
        statusBar.setMaximumSize(new Dimension(WindowConstants.WINDOW_SIZE.width, 120));  // Tamaño máximo para mantener el tamaño

        // Crear el panel del juego (game panel) con la imagen
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar la imagen y ajustarla al tamaño del panel
                ImageIcon gameImage = new ImageIcon(getClass().getResource("/images/Captura de pantalla 2024-10-18 221150.png"));
                Image image = gameImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        gamePanel.setPreferredSize(new Dimension(WindowConstants.WINDOW_SIZE.width, 480));  // Tamaño fijo de 1280x480
        gamePanel.setMaximumSize(new Dimension(WindowConstants.WINDOW_SIZE.width, 480));  // Tamaño máximo para mantener el tamaño

        // Crear la barra de acciones (action bar)
        actionBar = new JPanel();
        actionBar.setBackground(Color.CYAN);
        actionBar.setPreferredSize(new Dimension(WindowConstants.WINDOW_SIZE.width, 120));  // Tamaño fijo de 1280x120
        actionBar.setMaximumSize(new Dimension(WindowConstants.WINDOW_SIZE.width, 120));  // Tamaño máximo para mantener el tamaño

        // Añadir los paneles al mainPanel en orden de arriba hacia abajo
        mainPanel.add(statusBar);  // Barra de estado arriba
        mainPanel.add(gamePanel);  // Panel del juego en el medio
        mainPanel.add(actionBar);  // Barra de acciones abajo

        // Establecer el mainPanel como el contenedor principal de la ventana
        setContentPane(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }

}




