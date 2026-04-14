import java.util.Arrays;
import java.util.Scanner;

public class ArraySort {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);

        System.out.print("Enter the number of elements in array: ");
        int n = enter.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int a = i + 1;
            System.out.print("Elements " + a + " = ");
            arr[i] = enter.nextInt();
        }

        System.out.println("The array with no Sort: " + Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println("The array after Sort: " + Arrays.toString(arr));

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        double avg = (double) sum / n;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);

        enter.close();
    }
}
