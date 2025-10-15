import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int min = 100;

        for (int i = 0; i < 7; i++) {
            int number = Integer.parseInt(bf.readLine());

            if (number % 2 == 1) {
                sum += number;

                if (number < min) {
                    min = number;
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);

        }
    }
}
