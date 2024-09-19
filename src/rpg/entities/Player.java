package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;

public class Player {

    private String name;
    private HashMap<Stats, Integer> stats;

    public Player(String name){
        this.name = name;
        this.stats = new HashMap<>();

    }
}
