import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<cNode>[] arr;
    public static boolean visit[];

    public static long num[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        num = new long[N];
        visit = new boolean[N];
        long LCM = 1;

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            arr[a].add(new cNode(b, p, q));
            arr[b].add(new cNode(a, q, p));

            LCM *= (p * q / GCD(p, q));
        }

        num[0] = LCM;
        DFS(0);

        long gcd = num[0];
        for (int i = 1; i < N; i++) {
            gcd = GCD(gcd, num[i]);
        }
        for (int i = 0; i < N; i++) {
            bw.write(num[i] / gcd + " ");
        }

        bw.flush();
        bw.close();

    }

    public static class cNode {
        int node;
        int p;
        int q;

        public cNode(int node, int p, int q) {
            this.node = node;
            this.p = p;
            this.q = q;
        }
    }

    public static long GCD(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }

    public static void DFS(int node) {
        visit[node] = true;
        for (cNode adjNode : arr[node]) {
            int next = adjNode.node;
            if (!visit[next]) {
                num[next] = num[node] * adjNode.q / adjNode.p;
                DFS(next);
            }
        }
    }
}
