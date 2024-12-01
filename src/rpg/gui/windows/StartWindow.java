package rpg.gui.windows;

import rpg.gui.MainWindow;
import rpg.gui.buttons.LoadFileButton;
import rpg.gui.buttons.NewFileButton;
import rpg.gui.panels.BackgroundPanel;
import rpg.gui.labels.NameLabel;
import rpg.gui.panels.FilesPanel;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {

    private JPanel mainPanel;
    private JLabel titleLabel;
    private NameLabel[] fileLabels;
    private NewFileButton[] newFileButtons;
    private LoadFileButton[] loadFileButtons;

    public StartWindow() {
        setTitle("Java RPG");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
        setResizable(false);
        createUIComponents();
        setupLayout();
    }

    private void createUIComponents() {
        mainPanel = new FilesPanel();
        titleLabel = new JLabel("Java RPG");
        titleLabel.setForeground(Color.DARK_GRAY);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        fileLabels = new NameLabel[5];
        newFileButtons = new NewFileButton[5];
        loadFileButtons = new LoadFileButton[5];

        for (int i = 0; i < 5; i++) {
            fileLabels[i] = new NameLabel("Partida " + (i + 1)); // Placeholder para nombres de partidas
            newFileButtons[i] = new NewFileButton(i + 1, this);
            loadFileButtons[i] = new LoadFileButton(i + 1, this);
        }
    }

    private void setupLayout() {
        mainPanel.setLayout(new GridLayout(5, 2, 10, 10)); // 5 filas, 2 columnas con margen

        for (int i = 0; i < 5; i++) {
            mainPanel.add(fileLabels[i]);
            mainPanel.add(loadFileButtons[i]);
            mainPanel.add(newFileButtons[i]);
        }

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    public void startNewGame(int fileIndex) {
        // Aquí puedes guardar el progreso de la nueva partida
        System.out.println("Iniciando nueva partida " + fileIndex);
        MainWindow mainWindow = new MainWindow(); // Inicia la ventana principal
        mainWindow.setVisible(true); // Muestra la ventana principal
        // Guarda el índice de la partida en algún lugar para poder cargarlo más tarde
        // Por ejemplo, podrías usar un archivo o una base de datos para almacenar el progreso
    }

    public void loadGame(int fileIndex) {
        // Aquí puedes cargar el progreso de la partida
        System.out.println("Cargando partida " + fileIndex);
        MainWindow mainWindow = new MainWindow(); // Inicia la ventana principal
        mainWindow.setVisible(true); // Muestra la ventana principal
        // Carga el progreso del archivo correspondiente
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartWindow window = new StartWindow();
            window.setVisible(true);
        });
    }
}
