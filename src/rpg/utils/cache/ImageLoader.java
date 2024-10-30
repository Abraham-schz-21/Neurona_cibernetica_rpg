package rpg.utils.cache;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la imagen: " + path,
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();  // Esto mostrará detalles del error en la consola
        }
        return null;
    }
}

