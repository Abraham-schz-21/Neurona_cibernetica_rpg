package rpg.gui.labels;

import rpg.enums.BarType;
import rpg.gui.ui.BarLabelUI;

import javax.swing.*;
import java.awt.*;

public class BarLabel extends JLabel {
    private int barValue;
    private int maxValue;
    private final BarType type;

    public BarLabel(int value, int maxValue, BarType type) {
        this.barValue = value;
        this.maxValue = maxValue;
        this.type = type;
        initComponents();
    }

    public void initComponents() {
        setBarValue(barValue);
        setUI(new BarLabelUI(type));
        setPreferredSize(new Dimension(210, 60)); // Tamaño total de la barra
    }

    public void setBarValue(int value) {
        this.barValue = value;
        revalidate();
        repaint();
    }

    public int getBarValue() {
        return barValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}

