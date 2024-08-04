import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int a = N / 5;
        int b = (N - 5 * a) / 3;

        while (5 * a + 3 * b != N && a > 0) {
            a--;
            b = (N - 5 * a) / 3;
        }

        if (5 * a + 3 * b == N) {
            System.out.println(a + b);
        } else {
            System.out.println(-1);
        }
    }
}
