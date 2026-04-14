<<<<<<< HEAD
import java.util.Scanner;

public class MatrixSolution {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        System.out.print("Enter numbers of rows: ");
        int r = enter.nextInt();
        System.out.print("Enter numbers of columns: ");
        int c = enter.nextInt();
        int[][] A = new int[r][c];
        int[][] B = new int[r][c];
        int[][] C = new int[r][c];
        System.out.println("Enter A Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = enter.nextInt();
            }
        }
        System.out.println("Enter B Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("B[" + i + "][" + j + "] = ");
                B[i][j] = enter.nextInt();
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        System.out.println("C = A + B:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        enter.close();
    }
}
=======
import java.util.Scanner;

public class MatrixSolution {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        System.out.print("Enter numbers of rows: ");
        int r = enter.nextInt();
        System.out.print("Enter numbers of columns: ");
        int c = enter.nextInt();
        int[][] A = new int[r][c];
        int[][] B = new int[r][c];
        int[][] C = new int[r][c];
        System.out.println("Enter A Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = enter.nextInt();
            }
        }
        System.out.println("Enter B Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("B[" + i + "][" + j + "] = ");
                B[i][j] = enter.nextInt();
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        System.out.println("C = A + B:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        enter.close();
    }
}
>>>>>>> 0088b2f309d9d772e1cc0a1f61ca44a71985b779
