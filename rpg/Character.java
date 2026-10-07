package rpg;

public abstract class Character {
    protected String name;
    protected int maxHealth;
    protected int health;
    protected int attack;
    protected int defense;

    public Character(String name, int maxHealth, int attack, int defense) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attack = attack;
        this.defense = defense;
    }

    public abstract int getTotalAttack();

    public abstract int getTotalDefense();

    public void takeDamage(int damage) {
        int actual = Math.max(1, damage - getTotalDefense());
        health = Math.max(0, health - actual);
        System.out.println(name + " получает " + actual + " урона. Осталось HP: " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
