import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // D[N] = (N - 1) * (D[N - 1] + D[N - 2])
        int N = Integer.parseInt(bf.readLine());
        long[] D = new long[1000001];
        D[1] = 0;
        D[2] = 1;

        for (int i = 3; i < N + 1; i++) {
            D[i] = (i - 1) * (D[i - 1] + D[i - 2]) % 1000000000;
        }

        System.out.println(D[N]);
    }
}