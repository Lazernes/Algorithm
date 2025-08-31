import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /*
        (N+M)!/N!*M! = (N+M)!/(N+M-M)!M! => (N+M)C(M)
        */

        int[][] D = new int[201][201];
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = D[i - 1][j - 1] + D[i - 1][j];

                    if (D[i][j] > 1000000000) {
                        D[i][j] = 1000000001;   // K의 최대값
                    }
                }
            }
        }

        if (D[N + M][M] < K) {
            System.out.println(-1);
        } else {
            while (!(N == 0 && M == 0)) {
                if (D[N - 1 + M][M] >= K) {
                    System.out.print("a");
                    N--;
                } else {
                    System.out.print("z");
                    K = K - D[N - 1 + M][M];
                    M--;
                }
            }
        }

    }
}
