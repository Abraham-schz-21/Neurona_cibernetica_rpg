package rpg.items;

import rpg.entities.Player;
import rpg.enums.Stats;
import rpg.interfaces.Equipable;

import java.util.HashMap;

/**
 * Clase Equipment que representa un objeto equipable en el juego.
 */
public abstract class Equipment extends Item implements Equipable {

    protected HashMap<Stats, Integer> stats;

    /**
     * Constructor de la clase Equipment.
     */
    public Equipment() {
        super();
        stats = new HashMap<>();
    }

    /**
     * Método que equipa el objeto en el jugador.
     *
     * @param player El jugador que equipa el objeto.
     */
    @Override
    public void equip(Player player) {
        // Implementar la lógica para equipar el objeto en el jugador.
    }

    /**
     * Método que desequipa el objeto en el jugador.
     *
     * @param player El jugador que desequipa el objeto.
     */
    @Override
    public void unequip(Player player) {
        // Implementar la lógica para desequipar el objeto en el jugador.
    }
}
