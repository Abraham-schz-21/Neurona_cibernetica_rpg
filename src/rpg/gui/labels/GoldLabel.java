package rpg.gui.labels;

import rpg.gui.UIConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class GoldLabel extends JLabel {

    public GoldLabel() {
        initComponents();
        setPreferredSize(new Dimension(150, 40)); // Tamaño de la etiqueta
    }

    public void initComponents() {
        // Cargar la imagen original
        ImageCache.addImage("gold", "goldLabel.png");
        ImageIcon originalIcon = ImageCache.getImageIcon("gold");

        // Verificar si la imagen se cargó correctamente
        if (originalIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.err.println("Error loading image: goldLabel.png");
        }

        // Redimensionar la imagen manteniendo la relación de aspecto
        Image originalImage = originalIcon.getImage();
        int originalWidth = originalImage.getWidth(null);
        int originalHeight = originalImage.getHeight(null);

        // Calcular la escala para ajustar la imagen a 150x30
        double scale = Math.min(40.0 / originalHeight, 150.0 / originalWidth);
        int newWidth = (int) (originalWidth * scale);
        int newHeight = (int) (originalHeight * scale);

        // Escalar la imagen
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Crear un nuevo ImageIcon con la imagen escalada
        ImageIcon icon = new ImageIcon(scaledImage);

        // Configurar la etiqueta
        setIcon(icon);
        setText("1000"); // Cambia este valor por la cantidad de dinero del jugador
        setFont(UIConstants.LABEL_FONT.deriveFont(Font.BOLD, 9f)); // Ajusta el tamaño de la fuente
        setForeground(Color.WHITE);
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.LEFT); // Cambia a LEFT para evitar que el texto se salga
        setVerticalTextPosition(JLabel.CENTER);
        setHorizontalTextPosition(JLabel.CENTER); // Alinear el texto a la derecha del icono
        setIconTextGap(5); // Espacio entre el icono y el texto

        // Ajustar el tamaño de la etiqueta
        setPreferredSize(new Dimension(150, 40));
        setMinimumSize(new Dimension(150, 40));
        setMaximumSize(new Dimension(150, 40));
    }
}
