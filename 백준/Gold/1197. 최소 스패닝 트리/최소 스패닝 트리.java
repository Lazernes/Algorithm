import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static PriorityQueue<Edge> pq;
    public static int[] arr;

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            arr[b] = a;
        }
    }

    public static int find(int a) {
        if (a == arr[a]) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        arr = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.add(new Edge(A, B, C));
        }

        int sum = 0;
        int sumCount = 0;
        
        while (sumCount < V - 1) {
            Edge current = pq.poll();
            int s = current.start;
            int e = current.arrive;
            int w = current.weight;

            if (find(s) != find(e)) {
                union(s, e);
                sum += w;
                sumCount++;
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }

    public static class Edge implements Comparable<Edge> {
        int start;
        int arrive;
        int weight;

        public Edge(int start, int arrive, int weight) {
            this.start = start;
            this.arrive = arrive;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }

    }
}
