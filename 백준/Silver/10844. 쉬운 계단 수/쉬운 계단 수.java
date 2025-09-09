import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[][] D = new long[101][11];
        for (int i = 1; i < 11; i++) {
            D[1][i] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            D[i][0] = D[i - 1][1];
            D[i][9] = D[i - 1][8];

            for (int j = 1; j < 9; j++) {
                D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % 1000000000;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + D[N][i]) % 1000000000;
        }
        System.out.println(sum);
    }
}