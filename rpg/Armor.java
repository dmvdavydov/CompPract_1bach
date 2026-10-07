package rpg;

public class Armor {
    private final String name;
    private final int defenseBonus;

    public Armor(String name, int defenseBonus) {
        this.name = name;
        this.defenseBonus = defenseBonus;
    }

    public String getName() {
        return name;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    @Override
    public String toString() {
        return name + " (+" + defenseBonus + " защиты)";
    }
}
