import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int INF = 1000000*16+1;
    static int[][] W;
    static int[][] D;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        W = new int[n][n];
        D = new int[n][1 << 16];
        // 0, 2, 5 번째 도시를 갔으면 100101 = 32 + 4 + 1 = 37

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1));
    }

    // c번 도시에서 v 리스트 도시를 방문한 후 남은 모든 도시를 순회하기 위한 최소비용
    // 현재 방문하지 않은 모든 도시에 대해 반복하고, 방문하지 않은 도시를 i라고 하면
    // D[c][v] = min(D[c][v], D[i][v | (1<<i)] + W[c][i])
    static int tsp(int c, int v) {
        if (v == (1 << n) - 1) {    // 모든 도시를 방문
            return W[c][0] == 0 ? INF : W[c][0];
        }

        if (D[c][v] != 0) { // 이미 방문한 노드인 경우, 메모이제이션
            return D[c][v];
        }

        int min = INF;
        for (int i = 0; i < n; i++) {
            if ((v & (1 << i)) == 0 && W[c][i] != 0) {
                min = Math.min(min, tsp(i, (v | (1 << i))) + W[c][i]);
            }
        }

        D[c][v] = min;
        return D[c][v];
    }
}