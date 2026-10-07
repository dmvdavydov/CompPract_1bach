package rpg;

public class Weapon {
    private final String name;
    private final int attackBonus;

    public Weapon(String name, int attackBonus) {
        this.name = name;
        this.attackBonus = attackBonus;
    }

    public String getName() {
        return name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    @Override
    public String toString() {
        return name + " (+" + attackBonus + " атаки)";
    }
}
