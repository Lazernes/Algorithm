import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static int[] arr;
    public static PriorityQueue<Edge> pq;

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            arr[b] = a;
        }
    }

    public static int find(int a) {
        if (arr[a] == a) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        pq = new PriorityQueue<>();

        // A의 아스키 코드 65, a의 아스키코드 97
        // 아스키 코드가 97보다 작으면 38을 빼고 97보다 크면 96을 뺀다.
        int AllLineLength = 0;
        for (int i = 0; i < N; i++) {
            String inputString = bf.readLine();
            char[] charArr = inputString.toCharArray();

            for (int j = 0; j < N; j++) {
                int length = charArr[j];

                if (length == 48) {
                    continue;
                } else if (length < 97) {
                    length = length - 38;
                } else {
                    length = length - 96;
                }

                pq.add(new Edge(i, j, length));
                AllLineLength += length;
            }
        }

        int connectedLength = 0;
        int connectedComputer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                connectedComputer++;
                connectedLength += now.weight;
            }
        }

        if (connectedComputer == N - 1) {
            int answer = AllLineLength - connectedLength;
            bw.write(answer + "\n");
        } else {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }

    }
}
