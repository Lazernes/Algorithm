import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // D[N][L][R]: N개의 빌딩이 있고 왼쪽에 L개, 오른쪽에서 R개가 보일 때 가능할 경우의 수
    public static long[][][] D = new long[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        D[1][1][1] = 1;

        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j < L + 1; j++) {
                for (int k = 1; k < R + 1; k++) {
                    D[i][j][k] = (D[i - 1][j][k] * (i - 2) + D[i - 1][j][k - 1] + D[i - 1][j - 1][k]) % 1000000007;
                }
            }
        }

        System.out.println(D[N][L][R]);
    }
}