package rpg;

public class Player extends Character {
    private int level = 1;
    private int experience = 0;
    private Weapon weapon;
    private Armor armor;

    public Player(String name) {
        super(name, 100, 10, 5);
    }

    @Override
    public int getTotalAttack() {
        return attack + (weapon != null ? weapon.getAttackBonus() : 0);
    }

    @Override
    public int getTotalDefense() {
        return defense + (armor != null ? armor.getDefenseBonus() : 0);
    }

    public void gainExperience(int amount) {
        experience += amount;
        System.out.println("Получено " + amount + " опыта. Всего: " + experience + "/" + getExpToNextLevel());
        while (experience >= getExpToNextLevel()) {
            levelUp();
        }
    }

    private int getExpToNextLevel() {
        return level * 100;
    }

    private void levelUp() {
        experience -= getExpToNextLevel();
        level++;
        maxHealth += 10;
        health = maxHealth; // полное восстановление
        attack += 2;
        defense += 1;
        System.out.println("🎉 Уровень повышен! Теперь вы " + level + " уровня.");
    }

    public void equip(Weapon w) {
        this.weapon = w;
    }

    public void equip(Armor a) {
        this.armor = a;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public int getLevel() {
        return level;
    }

    public void printStats() {
        System.out.println("--- " + name + " (ур. " + level + ") ---");
        System.out.println("HP: " + health + "/" + maxHealth);
        System.out.println("Атака: " + getTotalAttack() + "  Защита: " + getTotalDefense());
        System.out.println("Оружие: " + (weapon != null ? weapon : "нет"));
        System.out.println("Броня:  " + (armor != null ? armor : "нет"));
    }
}
