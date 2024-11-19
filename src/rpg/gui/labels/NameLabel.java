package rpg.gui.labels;

import rpg.gui.ui.NameLabelUI;

import javax.swing.*;
import java.awt.*;

public class NameLabel extends JLabel {

    public NameLabel(String name) {
        super(name);
        setUI(new NameLabelUI());
        setPreferredSize(new Dimension(150, 40)); // Tamaño de la etiqueta
        setHorizontalAlignment(JLabel.LEFT); // Alinear a la izquierda
        setVerticalAlignment(JLabel.CENTER); // Alinear verticalmente al centro
    }

}
