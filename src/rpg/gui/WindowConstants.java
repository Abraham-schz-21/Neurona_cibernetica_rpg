package rpg.gui;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public interface WindowConstants {

    Dimension WINDOW_SIZE = new Dimension(1280, 720);
    int WINDOW_WIDTH = 1280;
    int TOP_HEIGHT = 120;
    int MIDDLE_HEIGHT = 320;
    int BOTTOM_HEIGHT = 241;
    int SIMPLE_MARGIN = 20;
    Dimension TOP_DIMENSION = new Dimension(WINDOW_WIDTH, TOP_HEIGHT);
    Dimension MIDDLE_DIMENSION = new Dimension(WINDOW_WIDTH, MIDDLE_HEIGHT);
    Dimension BOTTOM_DIMENSION = new Dimension(WINDOW_WIDTH, BOTTOM_HEIGHT);
    EmptyBorder EMPTY_BORDER = new EmptyBorder(SIMPLE_MARGIN, SIMPLE_MARGIN, SIMPLE_MARGIN,SIMPLE_MARGIN);

}