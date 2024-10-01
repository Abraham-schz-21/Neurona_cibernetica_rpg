package rpg.entities;

import rpg.enums.Stats;

public class Player extends GameCharacter {
    public Player(String name) {
        super(name);
    }

    @Override
    protected void initCharacter() {
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.ATTACK, 35);
        this.stats.put(Stats.DEFENSE, 15);
    }
}
