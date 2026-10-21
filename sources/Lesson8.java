import java.util.Arrays;

/**
 * Lesson8
 */
public class Lesson8 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 2, 3, 5};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(merge(arr, 0, 2, 5)));

    }

    public static int[] insertionSort(int[] A) {
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;
            while(i >= 0 && A[i] > key) {
                A[i+1] = A[i];
                i--;
            }
            A[i+1] = key;
        }
        return A;
    }

    public static int[] merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p+i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = A[q+i+1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(L));
        System.out.println(Arrays.toString(R));
        int i=0;
        int j=0;
        for (int k = p; k <= r; k++) {
            if (L[i] < R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
        return A;
    }
}