import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Node>> Graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            Graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Graph.get(start).add(new Node(arrive, weight));
        }

        PriorityQueue<Integer>[] dPq = new PriorityQueue[n + 1];    // D배열을 Pq로 선언
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };
        for (int i = 0; i < n + 1; i++) {
            dPq[i] = new PriorityQueue<>(k, cp);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(); // Dijkstra와 동일하게 Pq 선언
        pq.add(new Node(1, 0));
        dPq[1].add(0);
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowNode = now.arrival;
            int nowWeight = now.weight;

            for (int i = 0; i < Graph.get(nowNode).size(); i++) {
                Node next = Graph.get(nowNode).get(i);
                int nextNode = next.arrival;
                int nextWeight = next.weight;

                if (dPq[nextNode].size() < k) {
                    dPq[nextNode].add(nowWeight + nextWeight);
                    pq.add(new Node(nextNode, nowWeight + nextWeight));
                } else if (dPq[nextNode].peek() > nowWeight + nextWeight) {
                    dPq[nextNode].poll();
                    dPq[nextNode].add(nowWeight + nextWeight);
                    pq.add(new Node(nextNode, nowWeight + nextWeight));
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (dPq[i].size() == k) {
                bw.write(dPq[i].peek() + "\n");
            } else {
                bw.write("-1\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static class Node implements Comparable<Node> {
        int arrival;
        int weight;

        public Node(int arrival, int weight) {
            this.arrival = arrival;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }

    }
}
