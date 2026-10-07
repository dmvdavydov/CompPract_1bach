import java.util.Arrays;
import java.util.function.Function;

/*
Работа над ошибками,
Вспоминаем всё, что было

*/

public class Lesson6 {
    public static final int N_TIMES = 500;

    public static void main(String[] args) {
        // Работа над ошибками
        // 1. Можно убирать циклы там где они не нужны
        // long[] badTimes = benchmark(N_TIMES, Lesson6::loop3, 9);
        // long[] goodTimes = benchmark(N_TIMES, Lesson6::loop2, 9);
        // System.out.println(Arrays.stream(badTimes).average());
        // System.out.println(Arrays.stream(goodTimes).average());
        // 2. Лишнее создание переменной в цикле
        long[] times = new long[N_TIMES];
        long time1;
        for (int j = 0; j < times.length; j++) {
            time1 = System.nanoTime();
            func_int();
            times[j] = System.nanoTime() - time1;
        }

        long[] times2 = new long[N_TIMES];
        long time2;
        for (int j = 0; j < times.length; j++) {
            time2 = System.nanoTime();
            func_int2();
            times2[j] = System.nanoTime() - time2;
        }
        System.out.println(Arrays.stream(times).average());
        System.out.println(Arrays.stream(times2).average());
        // System.out.println(func1(8));

        // 3. Информация для пользователя!
        
        // На паре решали:
            // swap
            // int num1 = 37;
            // int num2 = 52;
            // num1 = num1 + num2;
            // num2 = num1 - num2;
            // num1 = num1 - num2;



            // Fibonacci
            // F(n) = F(n-1) + F(n-2), n > 1
            // F(n) = 1, n <= 1

            // //Euclid
            // 30 % 12 = 6
            // 12 % 6 = 0
    }

    public static void func_int() {
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            int a = i;
        }
    }

    public static void func_int2() {
        int b;
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            b = i;
        }
    }

    public static long[] benchmark(int n, Function<Integer, Integer> func, int arg0) {
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

    public static int func1(int n) {
        if (n <= 0)
            return n - 1;
        System.out.println(n);
        n = func1(n - 1);
        return n - 1;
    }

    public static int loop3(int n) {
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if (i + j + k == n)
                        res++;
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
                if (tmp >= 0 && tmp <= 9)
                    res++;
            }
        }
        return res;
    }
}
