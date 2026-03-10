
import java.util.*;

class ArmStrongNumber {

    void checkArm() {
        Scanner sc = new Scanner(System.in);

        System.out.print(
                "Enter A number: ");
        int num = sc.nextInt();
        // int n = num;
        int sum = 0;
        int result = 0;
        int temp = num;

        while (temp % 2 == 0) {
            result++;
            temp = temp / 10;
        }

        temp = num;
        while (temp % 2 == 0) {
            int n1 = temp % 10;
            sum += Math.pow(n1, result);
            temp = temp / 10;

        }
        if (sum == num) {
            System.out.println(num + " is a Armstrong Number... ");
        } else {
            System.out.println(num + " is not a Armstrong number....");
        }
    }
}

public class ArmNumb {

    public static void main(String[] args) {
        ArmStrongNumber check = new ArmStrongNumber();
        check.checkArm();
    }
}
