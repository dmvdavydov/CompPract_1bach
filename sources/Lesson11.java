import java.util.Arrays;
import java.util.Comparator;

/**
 * Lesson11
 */
public class Lesson11 {


    public static void main(String[] args) {
        String[] fruits = {"apple", "qiwi", "banana", "peach"};
        Comparator <String> myComparator = (String a, String b) -> Integer.compare(a.length(), b.length());
        Arrays.sort(fruits);
        System.out.println(Arrays.toString(fruits));
        Arrays.sort(fruits, myComparator);
        System.out.println(Arrays.toString(fruits));
    }
}