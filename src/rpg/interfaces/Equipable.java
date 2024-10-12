package rpg.interfaces;

import rpg.entities.Player;

public interface Equipable {
    void equip(Player player);

    void unequip(Player player);
}