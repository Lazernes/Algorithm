import java.io.*;
import java.util.*;

public class Main {

    static int[][] D;   // D[i][j]: i ~ j 구간의 행렬을 합치는 데 드는 최소 연산 횟수
    static int[][] Matrix;

    static int Cross(int s, int e) {
        int result = Integer.MAX_VALUE;

        if (D[s][e] != -1) {
            return D[s][e]; // 이미 계산헀으면 return
        }

        if (s == e) {
            return 0;
        }

        if (s + 1 == e) {
            return Matrix[s][0] * Matrix[s][1] * Matrix[e][1];
        }

        // 헹렬이 3개 이상일 경우
        for (int i = s; i < e; i++) {
            result = Math.min(result, Matrix[s][0] * Matrix[i][1] * Matrix[e][1] + Cross(s, i) + Cross(i + 1, e));
        }

        return D[s][e] = result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        D = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                D[i][j] = -1;
            }
        }

        Matrix = new int[N][2]; // 0번째 원소: column, 1번째 원소: row
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            Matrix[i][0] = Integer.parseInt(st.nextToken());
            Matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Cross(0, N - 1));

    }
}
