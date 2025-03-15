import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[][] D;
    public static int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        D = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i != j) {
                    D[i][j] = INF;
                } else {
                    D[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            D[A][B] = 1;
            D[B][A] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    D[j][k] = Math.min(D[j][k], D[j][i] + D[i][k]);
                }
            }
        }

        int answer = 0;
        int sum = INF;

        for (int i = 1; i < N + 1; i++) {
            int tempSum = 0;
            for (int j = 1; j < N + 1; j++) {
                if (D[i][j] != INF) {
                    tempSum += D[i][j];
                }
            }

            if (tempSum < sum) {
                sum = tempSum;
                answer = i;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
