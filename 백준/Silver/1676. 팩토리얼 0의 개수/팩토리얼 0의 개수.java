import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int count = 0;

        for (int i = 0; i < N + 1; i++) {
            int n = i;

            while (n >= 5 && n % 5 == 0) {
                count++;
                n = n / 5;
            }
        }

        System.out.println(count);
    }
}