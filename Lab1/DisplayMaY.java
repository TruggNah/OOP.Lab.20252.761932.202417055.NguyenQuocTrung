import java.util.Scanner;
public class DisplayMaY {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);

        System.out.print("Please enter the year: ");
        int year = enter.nextInt();

        if (year < 0) {
            System.out.println("The year is invalid!");
        } else {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(year + " is Leap year");
            } else {
                System.out.println(year + " is Normal year");
            }
        }

        enter.close();
    }

}