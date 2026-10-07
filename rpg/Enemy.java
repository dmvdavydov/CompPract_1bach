package rpg;

import java.util.Random;

public class Enemy extends Character {
    public Enemy(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
    }

    @Override
    public int getTotalAttack() {
        return attack;
    }

    @Override
    public int getTotalDefense() {
        return defense;
    }

    /** Генерация случайного врага с учётом уровня игрока. */
    public static Enemy randomForLevel(int playerLevel) {
        Random rnd = new Random();
        String[] names = { "Гоблин", "Орк", "Скелет", "Волк", "Разбойник" };
        String name = names[rnd.nextInt(names.length)];

        int hp = 30 + playerLevel * 10 + rnd.nextInt(20);
        int atk = 5 + playerLevel * 2 + rnd.nextInt(4);
        int def = 2 + playerLevel + rnd.nextInt(3);
        return new Enemy(name, hp, atk, def);
    }

    /** Опыт, который даёт враг. */
    public int getExpReward() {
        return 30 + maxHealth / 2 + new Random().nextInt(20);
    }
}
