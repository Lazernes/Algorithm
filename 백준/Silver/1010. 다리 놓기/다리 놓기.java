import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[][] D = new int[30][30];
        for (int i = 1; i < 30; i++) {
            D[1][i] = i;
            D[i][i] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = i; j < 30; j++) {
                D[i][j] = D[i][j - 1] + D[i - 1][j - 1];
            }
        }

        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(D[N][M]);
        }

    }
}