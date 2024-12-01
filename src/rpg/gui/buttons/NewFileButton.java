package rpg.gui.buttons;

import rpg.gui.windows.StartWindow;

import javax.swing.*;
import java.awt.*;

public class NewFileButton extends BaseButton {
    private int fileIndex;
    private StartWindow startWindow;

    public NewFileButton(int fileIndex, StartWindow startWindow) {
        super("Nueva Partida " + fileIndex);
        this.fileIndex = fileIndex;
        this.startWindow = startWindow;
        addActionListener(e -> startWindow.startNewGame(fileIndex));

        // Establecer un tamaño preferido para el botón
        setPreferredSize(new Dimension(150, 40)); // Ajusta el ancho y el alto según sea necesario
    }

    @Override
    protected void initIcons() {
        // Inicializa los iconos si es necesario
    }
}
