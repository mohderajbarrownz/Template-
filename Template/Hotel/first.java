
import java.util.*;

public class first {

    public static int sum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first Number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter Second Number: ");
        int num2 = sc.nextInt();

        int result = num1 + num2;

        System.out.print("Total Sum Number: " + result);
        return result;
    }

    public static void main(String args[]) {
        sum();
    }
}
