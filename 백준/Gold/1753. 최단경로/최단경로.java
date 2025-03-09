import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<ArrayList<Node>> Graph;
    public static int[] D;
    public static boolean[] Visit;
    public static int INF = 2147483647;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        D = new int[V + 1];
        Visit = new boolean[V + 1];

        Graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            Graph.add(new ArrayList<>());
        }

        int K = Integer.parseInt(bf.readLine());
        for (int i = 1; i < V + 1; i++) {
            if (i == K) {
                D[i] = 0;
            } else {
                D[i] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Graph.get(u).add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            Visit[now.v] = true;

            for (int i = 0; i < Graph.get(now.v).size(); i++) {
                Node next = Graph.get(now.v).get(i);
                int nextNode = next.v;
                int nextWeight = next.w;

                if (Visit[nextNode]) {
                    continue;
                }

                if (D[now.v] + nextWeight < D[nextNode]) {
                    D[nextNode] = D[now.v] + nextWeight;
                    pq.add(new Node(nextNode, D[nextNode]));

                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (D[i] != INF) {
                bw.write(D[i] + "\n");
            } else {
                bw.write("INF" + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }

}
