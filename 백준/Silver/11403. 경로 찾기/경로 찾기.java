import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] graph;

    public static void next(int a, boolean[] visit) {
        for (int i = 0; i <= N; i++) {
            if (graph[a][i] == 1 && !visit[i]) {
                visit[i] = true;
                next(i, visit);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bf.readLine());
        graph = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            boolean[] visit = new boolean[N + 1];
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == 1 && !visit[j]) {
                    visit[j] = true;
                    next(j, visit);
                }
            }

            for (int j = 1; j <= N; j++) {
                if (visit[j]) {
                    bw.write("1 ");
                } else {
                    bw.write("0 ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
}
