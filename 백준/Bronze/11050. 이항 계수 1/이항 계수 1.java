import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int result = 1;
        int result_tmp = 1;

        for (int i = 1; i <= K; i++) {
            result = result * N;
            N--;
            result_tmp = result_tmp * i;
        }

        System.out.println(result / result_tmp);
    }
}