import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int count = 0;
        int sub = 1;

        while (N > 0) {
            N = N - sub;
            count++;
            sub = count * 6;
        }

        System.out.print(count);
    }
}