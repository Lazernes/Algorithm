import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static Edge edges[];
    public static long D[];
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edges = new Edge[M + 1];
        D = new long[N + 1];
        Arrays.fill(D, INF);
        D[1] = 0;

        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, weight);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M + 1; j++) {
                int start = edges[j].start;
                int end = edges[j].end;
                int weight = edges[j].weight;

                if (D[start] != INF && D[end] > D[start] + weight) {
                    D[end] = D[start] + weight;
                }
            }
        }

        boolean update = false;

        for (int j = 1; j < M + 1; j++) {
            int start = edges[j].start;
            int end = edges[j].end;
            int weight = edges[j].weight;

            if (D[start] != INF && D[end] > D[start] + weight) {
                update = true;
                break;
            }
        }

        if (update) {
            bw.write(-1 + "\n");
        } else {
            for (int i = 2; i < N + 1; i++) {
                if (D[i] != INF) {
                    bw.write(D[i] + "\n");
                } else {
                    bw.write(-1 + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }

    public static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
