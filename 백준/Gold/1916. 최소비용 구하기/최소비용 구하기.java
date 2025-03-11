import java.io.*;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Node>> City;
    public static int[] D;
    public static boolean[] Visit;
    public static int INF = 2147483647;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        D = new int[N + 1];
        Visit = new boolean[N + 1];

        City = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            City.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            City.get(start).add(new Node(arrive, weight));
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int arrival = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            if (i == start) {
                D[i] = 0;
            } else {
                D[i] = INF;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (Visit[now.v]) {
                continue;
            }
            Visit[now.v] = true;

            for (int i = 0; i < City.get(now.v).size(); i++) {
                Node next = City.get(now.v).get(i);

                int nextNode = next.v;
                int nextWeight = next.weight;

                if (D[now.v] + nextWeight < D[nextNode]) {
                    D[nextNode] = D[now.v] + nextWeight;
                    pq.add(new Node(nextNode, D[nextNode]));
                }
            }
        }

        bw.write(D[arrival] + "\n");
        bw.flush();
        bw.close();
    }

    public static class Node implements Comparable<Node> {
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
