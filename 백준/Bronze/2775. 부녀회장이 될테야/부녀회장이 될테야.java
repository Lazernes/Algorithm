import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[][] D = new int[15][15];

        // 배열 초기화
        D[0][1] = 1;
        for (int i = 1; i < 15; i++) {
            D[0][i] = i;
            D[i][1] = 1;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1];
            }
        }

        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            System.out.println(D[k][n]);
        }
    }
}
