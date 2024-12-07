package rpg.gui.buttons;

import rpg.gui.MainWindow;
import rpg.gui.buttons.events.AttackEvent;

public class AttackButton extends BaseButton {
    private MainWindow game;
    public AttackButton() {
        super("ATACAR");
        this.game = game; // Inicializa la referencia a MainWindow
        addActionListener(new AttackEvent(game));
    }

    @Override
    protected void initIcons() {
        // Inicialización de iconos, si es necesario
    }
}
