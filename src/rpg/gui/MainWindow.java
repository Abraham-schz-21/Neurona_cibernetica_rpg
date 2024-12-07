package rpg.gui;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.basic.Harpy;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;
import rpg.gui.windows.StartWindow;
import rpg.utils.GameProgressManager;
import rpg.utils.Randomize;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JDesktopPane desktopPane;
    private TopPanel topPanel;
    private MiddlePanel middlePanel;
    private BottomPanel bottomPanel;
    private JPanel mainPanel;
    private Player player; // Instancia del jugador
    private Enemy enemy;   // Instancia del enemigo
    private JTextArea textArea; // Área de texto para mostrar mensajes

    public MainWindow() {
        initComponents();
        initializeGame();
    }

    private void initializeGame() {
        // Inicializar el jugador
        player = new Player("ZEUS");

        // Inicializar las barras en el TopPanel
        topPanel.getLifeLabel().setBarValue(100);
        topPanel.getMagicLabel().setBarValue(0);
        topPanel.getExpLabel().setBarValue(0);
        topPanel.getGoldLabel().setText("0"); // Inicializar oro en 0

        // Inicializar el primer enemigo
        enemy = Randomize.getRandomEnemy();
        middlePanel.setEnemy(enemy); // Método que debes implementar en MiddlePanel
    }

    // Métodos para obtener los paneles
    public TopPanel getTopPanel() {
        return topPanel;
    }

    public MiddlePanel getMiddlePanel() {
        return middlePanel;
    }

    public BottomPanel getBottomPanel() {
        return bottomPanel;
    }


    public Enemy getEnemy() {
        return enemy; // Devuelve el enemigo actual
    }

    public Player getPlayer() {
        return player; // Devuelve el jugador actual
    }

    public void appendText(String text) {
        textArea.append(text + "\n"); // Agrega texto al área de texto
        textArea.setCaretPosition(textArea.getDocument().getLength()); // Desplaza el scroll al final
    }

    public void checkGameStatus() {
        if (!player.isAlive()) {
            appendText("Has muerto. Fin del juego.");
            // Lógica adicional para manejar el fin del juego
        } else if (!enemy.isAlive()) {
            appendText("Has derrotado al enemigo.");
            // Lógica adicional para manejar la victoria
        }
    }

    private void initComponents() {
        desktopPane = new JDesktopPane();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Inicializar los paneles usando las dimensiones de WindowConstants
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel(this);

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
        // Agregar el área de texto a la ventana
        setVisible(true);
        setResizable(false);
    }

    private void showStartWindow() {
        StartWindow startWindow = new StartWindow();
        startWindow.setVisible(true); // Muestra la ventana de carga de partida
    }

    public void saveGame(int fileIndex, String progressData) {
        GameProgressManager.saveProgress(fileIndex, progressData);
    }

    public void loadGame(int fileIndex) {
        String progressData = GameProgressManager.loadProgress(fileIndex);
        // Aquí debes procesar el progreso cargado y actualizar el estado del juego
        System.out.println("Cargando progreso: " + progressData);
    }
    public static void main(String[] args) {
        new MainWindow();
    }

}


