package rpg;

import javax.swing.JOptionPane;
import rpg.entities.Player;
import rpg.items.Inventory;
import rpg.items.armors.Armor;
import rpg.items.armors.IronArmor;
import rpg.items.armors.WoodArmor;
import rpg.items.miscs.Misc;
import rpg.items.miscs.SquirrelPelt;
import rpg.items.miscs.WolfPelt;
import rpg.items.weapons.IronSword;
import rpg.items.weapons.SteelSword;
import rpg.items.weapons.Weapon;

public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory(10);

        Armor armor = new WoodArmor();
        inventory.addItem(armor);

        Armor armor1 = new IronArmor();
        inventory.addItem(armor1);

        Misc misc = new WolfPelt();
        inventory.addItem(misc);

        Misc misc2 = new SquirrelPelt();
        inventory.addItem(misc2);

        Weapon weapon = new IronSword();
        inventory.addItem(weapon);

        Weapon weapon1 = new SteelSword();
        inventory.addItem(weapon1);

        String armorMessage = "Armaduras en inventario:\n";
        for (Armor a : inventory.getArmors()) {
            armorMessage += "Nombre: " + a.getName() + "\n Descripción: " + a.getDescription() + "\n Precio: " + a.getPrice() +
                    "\n Tipo: " + a.getType() + "\n";
        }
        JOptionPane.showMessageDialog(null, armorMessage, "Armaduras", JOptionPane.INFORMATION_MESSAGE);

        String miscMessage = "Objetos misceláneos en inventario:\n";
        for (Misc m : inventory.getMiscs()) {
            miscMessage += "Nombre: " + m.getName() + "\n Descripción: " + m.getDescription() + "\n Precio: " + m.getPrice() +
                    "\n Tipo: " + m.getType() + "\n";
        }
        JOptionPane.showMessageDialog(null, miscMessage, "Misceláneos", JOptionPane.INFORMATION_MESSAGE);

        String weaponMessage = "Armas en inventario:\n";
        for (Weapon m : inventory.getWeapons()) {
            weaponMessage += "Nombre: " + m.getName() + "\n Descripción: " + m.getDescription() + "\n Precio: " + m.getPrice() +
                    "\n Tipo: " + m.getType() + "\n";
        }
        JOptionPane.showMessageDialog(null, weaponMessage, "Armas", JOptionPane.INFORMATION_MESSAGE);
    }
}