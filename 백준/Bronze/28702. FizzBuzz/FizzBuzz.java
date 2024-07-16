import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] st;
        st = new String[3];

        int a = 0;
        int b = 0;

        for (int i = 0; i < 3; i++) {
            st[i] = scanner.next();

            if (!st[i].equals("Fizz") && !st[i].equals("Buzz") && !st[i].equals("FizzBuzz")) {
                a = i;
                b = Integer.parseInt(st[i]);
            }
        }

        if (a == 0) {
            b = b + 3;
        } else if (a == 1) {
            b = b + 2;
        } else if (a == 2) {
            b = b + 1;
        }

        if (b % 3 == 0 && b % 5 != 0) {
            System.out.println("Fizz");
        } else if (b % 3 != 0 && b % 5 == 0) {
            System.out.println("Buzz");
        } else if (b % 3 == 0 && b % 5 == 0) {
            System.out.println("FizzBuzz");
        } else {
            System.out.println(b);
        }


    }
}
