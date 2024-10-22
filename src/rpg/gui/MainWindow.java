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
        setSize(WindowConstants.WINDOW_SIZE);  // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setContentPane(mainPanel);
        setVisible(true);
    }

    private void createUIComponents() {
        // Usamos GridBagLayout para organizar los paneles
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;  // Los componentes deben ocupar todo el espacio disponible
        gbc.weightx = 1.0;  // Los paneles ocuparán todo el ancho de la ventana
        gbc.gridx = 0;  // Todos los paneles estarán en la columna 0 (horizontalmente centrados)

        // Crear el statusBar (Barra de estado)
        statusBar = new JPanel();
        statusBar.setBackground(Color.CYAN);
        gbc.gridy = 0;
        gbc.weighty = 0.1;
        statusBar.setPreferredSize(new Dimension(WindowConstants.WINDOW_SIZE.width, 120));// Fijo a 1280x120
        mainPanel.add(statusBar, gbc);

        // Crear el gamePanel con una imagen de fondo
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar la imagen de fondo y ajustarla al tamaño del panel
                ImageIcon gameImage = new ImageIcon(getClass().getResource("/images/Captura de pantalla 2024-10-18 221150.png"));
                Image image = gameImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        gbc.gridy = 1;
        gbc.weighty = 0.6;
        gamePanel.setPreferredSize(new Dimension(WindowConstants.WINDOW_SIZE.width, 480));  // Fijo a 1280x480
        mainPanel.add(gamePanel, gbc);

        // Crear el actionBar (Barra de acciones)
        actionBar = new JPanel();
        actionBar.setBackground(Color.CYAN);
        gbc.gridy = 2;
        gbc.weighty = 0.1;
        actionBar.setPreferredSize(new Dimension(WindowConstants.WINDOW_SIZE.width, 120));  // Fijo a 1280x120
        mainPanel.add(actionBar, gbc);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}





