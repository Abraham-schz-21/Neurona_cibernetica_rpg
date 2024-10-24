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
        // Definir tamaño de ventana (1280x720)
        setSize(WindowConstants.WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        createUIComponents();  // Asegurarse de que se creen los componentes

        setContentPane(mainPanel);  // Establecer el mainPanel como el contenido de la ventana
        setVisible(true);
    }

    private void createUIComponents() {
        // Usamos GridBagLayout para organizar los paneles
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;  // Los componentes deben ocupar todo el espacio disponible
        gbc.weightx = 1.0;  // Los paneles ocuparán todo el ancho de la ventana
        gbc.gridx = 0;  // Todos los paneles estarán en la columna 0 (horizontalmente centrados)

        // Crear el statusBar (Barra de estado) con una imagen de alta calidad
        statusBar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Cargar la imagen de fondo y ajustarla al tamaño del panel con alta calidad
                ImageIcon statusImage = new ImageIcon(getClass().getResource("/images/Imagen1.jpg"));
                Image image = statusImage.getImage();
                g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        gbc.gridy = 0;
        gbc.weighty = 0.2;
        mainPanel.add(statusBar, gbc);  // Añadir statusBar al mainPanel

        // Crear el gamePanel con una imagen de alta calidad
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Cargar la imagen de fondo y ajustarla al tamaño del panel con alta calidad
                ImageIcon gameImage = new ImageIcon(getClass().getResource("/images/Imagen2.jpg"));
                Image image = gameImage.getImage();
                g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        gbc.gridy = 1;
        gbc.weighty = 0.45;  // Ajuste de tamaño del gamePanel
        mainPanel.add(gamePanel, gbc);  // Añadir gamePanel al mainPanel

        // Crear el actionBar (Barra de acciones) con una imagen de alta calidad
        actionBar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Cargar la imagen de fondo y ajustarla al tamaño del panel con alta calidad
                ImageIcon actionImage = new ImageIcon(getClass().getResource("/images/imagen3.jpg"));
                Image image = actionImage.getImage();
                g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        gbc.gridy = 2;
        gbc.weighty = 0.35;  // Aumentar el tamaño de la actionBar (35% del total)
        mainPanel.add(actionBar, gbc);  // Añadir actionBar al mainPanel
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}






