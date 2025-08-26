import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(bf.readLine());

        int[] D = new int[M];
        double[] P = new double[M];
        double result = 0.0;

        int sum = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());


        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            D[i] = input;
            sum += input;
        }

        int K = Integer.parseInt(bf.readLine());

        for (int i = 0; i < M; i++) {
            if (D[i] >= K) {
                P[i] = 1.0;
            }

            for (int j = 0; j < K; j++) {
                P[i] = P[i] * ((double) (D[i] - j) / (sum - j));
            }

            result += P[i];
        }

        System.out.println(result);
    }
}