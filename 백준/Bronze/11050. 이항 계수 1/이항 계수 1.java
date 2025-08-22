import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] D = new int[11][11];

        // 배열 초기화
        for (int i = 0; i < 11; i++) {
            D[i][1] = 1;
            D[i][i] = 1;
            D[i][0] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }

        System.out.println(D[N][K]);
    }
}
