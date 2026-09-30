
import java.util.Random;
import java.util.Arrays;

/**
 * Lesson5
 * Функции, их аргументы и возвращаемое значение.
 * Массивы, класс java.util.Arrays, java.util.Random;
 */
public class Lesson5 {

    public static void main(String[] args) {
        Random rand = new Random(37);
        Random rand2 = new Random(37);
        int[] array = new int[5];
        System.out.println(rand.nextInt());
        System.out.println(rand2.nextInt());

        int[] array2 = new int[]{4, 5, 6, 7, 8};
        int[] array3 = {4 , 5, 6, 7, 8};
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] +" ");
        }
        System.out.println("\n");
        printArray(array3);
    }

    /**
     * Функция, которая проверяет является ли строка палиндромом--
     * 
     * @param str
     * @return Возвращает логическое значение
     */
    static boolean isPalindrom(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     *  Печать массива
     * @param array3 : массив целых чисел
     * 
    */
    static void printArray(int[] array3){
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] +" ");
        }
    }
}
