import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static long[][] D;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        D = new long[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == j) {
                    D[i][j] = 0;
                } else {
                    D[i][j] = INF;
                }
            }
        }   // 배열 초기화

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (D[start][arrive] > weight) {
                D[start][arrive] = weight;
            }
        }   // 최단 거리 배열에 그래프 데이터 저장하기

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    D[j][k] = Math.min(D[j][k], D[j][i] + D[i][k]);
                }
            }
        }   // 플로이드-위셜 점화식 사용

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (D[i][j] == INF) {
                    bw.write(0 + " ");
                } else {
                    bw.write(D[i][j] + " ");
                }
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }


}
