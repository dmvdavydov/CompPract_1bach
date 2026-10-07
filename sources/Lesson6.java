import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.LongStream;

/*
Работа над ошибками,
Вспоминаем всё, что было

*/

public class Lesson6 {
    public static final int N_TIMES = 500;
    public static void main(String[] args) {
        // Работа над ошибками
        // 1. Можно убирать циклы там где они не нужны
        long[] badTimes = benchmark(N_TIMES, Lesson6::loop3, 9);
        long[] goodTimes = benchmark(N_TIMES, Lesson6::loop2, 9);
        System.out.println(Arrays.stream(badTimes).average());
        System.out.println(Arrays.stream(goodTimes).average());

        // 2. Лишнее создание переменной в цикле
        // 3. Информация для пользователя
    }

    public static long[] benchmark(int n, Function <Integer, Integer> func, int arg0) {
        long[] res = new long[n];
        long startTime;
        int resFunc;
        for (int i = 0; i < n; i++) {
            startTime = System.nanoTime();
            resFunc = func.apply(arg0);
            res[i] = System.nanoTime() - startTime;
        }
        return res;
    }

    public static int loop3(int n) {
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if (i + j + k == n) res++;
                }
            }
        }
        return res;
    }

    public static int loop2(int n) {
        int res = 0, tmp;
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                tmp = n - j - i;
                if (tmp >= 0 && tmp <= 9) res++;
            }
        }
        return res;
    }
}
