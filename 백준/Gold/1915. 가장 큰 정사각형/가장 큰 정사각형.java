import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;

    public static int[][] D;

    public static int Min(int a, int b, int c) {
        int min = Math.min(a, b);
        min = Math.min(min, c);

        return min;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = new int[N][M];
        int max = 0;

        for (int i = 0; i < N; i++) {
            String input = bf.readLine();

            for (int j = 0; j < M; j++) {
                D[i][j] = input.charAt(j) - '0';
                
                if (D[i][j] == 1) {
                    max = 1;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (D[i][j] == 1) {
                    D[i][j] = Min(D[i - 1][j - 1], D[i - 1][j], D[i][j - 1]) + 1;
                }

                if (max < D[i][j]) {
                    max = D[i][j];
                }
            }
        }

        System.out.println(max * max);
    }
}
