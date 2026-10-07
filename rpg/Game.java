package rpg;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Player player;
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    // Пулы возможного лута
    private static final Weapon[] WEAPONS = {
            new Weapon("Ржавый меч", 3),
            new Weapon("Стальной меч", 7),
            new Weapon("Боевой топор", 10),
            new Weapon("Легендарный клинок", 15)
    };
    private static final Armor[] ARMORS = {
            new Armor("Кожаная куртка", 2),
            new Armor("Кольчуга", 5),
            new Armor("Латные доспехи", 9),
            new Armor("Драконья чешуя", 14)
    };

    public Game(Player player) {
        this.player = player;
    }

    public void run() {
        printLogoFromFile();
        System.out.println("=== Добро пожаловать в RPG! Цель — достичь 10 уровня. ===");
        player.printStats();

        while (player.getLevel() < 10 && player.isAlive()) {
            System.out.println("\n1) Искать приключения");
            System.out.println("2) Посмотреть характеристики");
            System.out.println("3) Выйти из игры");
            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> fight();
                case "2" -> player.printStats();
                case "3" -> {
                    System.out.println("До встречи!");
                    return;
                }
                default -> System.out.println("Неизвестная команда.");
            }
        }

        if (player.getLevel() >= 10) {
            System.out.println("\n🏆 ПОБЕДА! Вы достигли 10 уровня!");
        } else {
            System.out.println("\n💀 Вы погибли. Игра окончена.");
        }
    }

    private void fight() {
        Enemy enemy = Enemy.randomForLevel(player.getLevel());
        System.out.println("\n⚔ Вы встретили: " + enemy.getName()
                + " (HP:" + enemy.getHealth()
                + " ATK:" + enemy.getTotalAttack()
                + " DEF:" + enemy.getTotalDefense() + ")");

        // Бой по очереди: игрок → враг
        while (player.isAlive() && enemy.isAlive()) {
            enemy.takeDamage(player.getTotalAttack());
            if (!enemy.isAlive())
                break;
            player.takeDamage(enemy.getTotalAttack());
        }

        if (player.isAlive()) {
            System.out.println("✅ Победа!");
            player.gainExperience(enemy.getExpReward());
            tryDropLoot();
        }
    }

    private void tryDropLoot() {
        if (random.nextInt(100) >= 40)
            return; // 40% шанс лута

        if (random.nextBoolean()) {
            Weapon w = WEAPONS[random.nextInt(WEAPONS.length)];
            System.out.println("Найден предмет: " + w);
            if (askEquip("экипировать это оружие"))
                player.equip(w);
        } else {
            Armor a = ARMORS[random.nextInt(ARMORS.length)];
            System.out.println("Найден предмет: " + a);
            if (askEquip("экипировать эту броню"))
                player.equip(a);
        }
    }

    private boolean askEquip(String action) {
        System.out.print("Хотите " + action + "? (д/н): ");
        return scanner.nextLine().trim().equalsIgnoreCase("д");
    }

    private static void printLogoFromFile() {
        // Path.of() доступен с Java 11. Если у студентов Java 8, используйте Paths.get("logo.txt")
        Path path = Path.of("logo.txt"); 
        
        try {
            // Считываем все строки сразу в List
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            
            // Выводим (можно использовать обычный цикл for, если stream'ы еще не прошли)
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Файл logo.txt не найден в папке проекта.");
        }
    }

    public static void main(String[] args) {
        System.out.print("Введите имя героя: ");
        String name = new Scanner(System.in).nextLine();
        new Game(new Player(name)).run();
    }
}
