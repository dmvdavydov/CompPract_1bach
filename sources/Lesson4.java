import java.util.Scanner;

public class Lesson4 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String scanStr = sc.nextLine();
        String testStr = "Test";
        String testStr2 = new String();
        System.out.println(testStr2);
        String testStr3 = new String("Test");
        System.out.println(testStr == testStr3);
        String substr = "hell";
        String str = "o worldhell!";
        System.out.println(str.charAt(3));
        System.out.println(str.length());
        System.out.println(str.contains(substr));
        // Задача: 1. является ли заданная строка палиндромом
        // Задача: 2. Проверить входит ли подстрока substr в строку str (не использовать
        // contains)

    }
}
