import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // D[N][L][R] = N개의 수열을 수행하고있고 왼쪽이 L, 오른쪽이 R 자리에 있을 때 최소 누적 힘
    public static long[][][] D = new long[100001][5][5];

    // mp[n][m] = n에서 m으로 발을 옮길 때 드는 힘
    public static int[][] mp =
            {{0, 2, 2, 2, 2},
                    {2, 1, 3, 4, 3},
                    {2, 3, 1, 3, 4},
                    {2, 4, 3, 1, 3},
                    {2, 3, 4, 3, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 100001; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    D[i][j][k] = 100001 * 4;
                }
            }
        }
        D[0][0][0] = 0;

        int n = 1;
        StringTokenizer st = new StringTokenizer(bf.readLine());

        while (true) {
            int nextStep = Integer.parseInt(st.nextToken());
            if (nextStep == 0) {
                break;
            }

            // 오른발을 옮겼을 때 최소 힘
            for (int i = 0; i < 5; i++) {
                if (nextStep == i) {
                    continue;
                }
                for (int j = 0; j < 5; j++) {
                    D[n][i][nextStep] = Math.min(D[n - 1][i][j] + mp[j][nextStep], D[n][i][nextStep]);
                }
            }

            // 왼발을 옮겼을 때 최소 힘
            for (int i = 0; i < 5; i++) {
                if (nextStep == i) {
                    continue;
                }
                for (int j = 0; j < 5; j++) {
                    D[n][nextStep][i] = Math.min(D[n - 1][j][i] + mp[j][nextStep], D[n][nextStep][i]);
                }
            }

            n++;
        }

        n--;
        long min = 100001 * 4;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, D[n][i][j]);
            }
        }

        System.out.println(min);
    }
}
