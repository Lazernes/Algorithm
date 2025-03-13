import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static Edge[] Graph;
    public static long[] D;
    public static int[] CityMoney;
    public static long MIN = Long.MIN_VALUE;
    public static long MAX = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Graph = new Edge[M];
        D = new long[N];
        CityMoney = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Graph[i] = new Edge(s, e, w);
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            CityMoney[i] = Integer.parseInt(st.nextToken());

            if (i == start) {
                D[i] = 0;
            } else {
                D[i] = MIN;
            }
        }

        D[start] = CityMoney[start];

        for (int i = 0; i < N + 50; i++) {
            for (int j = 0; j < M; j++) {
                int s = Graph[j].s;
                int e = Graph[j].e;
                int w = Graph[j].w;

                if (D[s] == MIN) {
                    continue;
                } else if (D[s] == MAX) {
                    D[e] = MAX;
                } else if (D[e] < D[s] + CityMoney[e] - w) {
                    D[e] = D[s] + CityMoney[e] - w;
                    if (i > N - 1) {
                        D[e] = MAX;
                    }
                }
            }

        }

        if (D[end] == MIN) {
            bw.write("gg\n");
        } else if (D[end] == MAX) {
            bw.write("Gee\n");
        } else {
            bw.write(D[end] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}
