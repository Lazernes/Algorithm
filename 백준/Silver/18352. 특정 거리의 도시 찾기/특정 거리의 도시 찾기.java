import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<ArrayList<Integer>> Graph;
    public static boolean[] Visit;
    public static int[] min;

    public static void BFS(int a) {
        Queue<Integer> qu = new LinkedList<>();

        qu.offer(a);
        Visit[a] = true;
        min[a] = 0;

        while (!qu.isEmpty()) {
            int node = qu.poll();
            for (int i = 0; i < Graph.get(node).size(); i++) {
                int temp = Graph.get(node).get(i);
                if (!Visit[temp]) {
                    Visit[temp] = true;
                    min[temp] = min[node] + 1;
                    qu.offer(temp);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());   // 도시의 개수
        int M = Integer.parseInt(st.nextToken());   // 도로의 개수
        int K = Integer.parseInt(st.nextToken());   // 거리 정보
        int X = Integer.parseInt(st.nextToken());   // 출발 도시

        Graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            Graph.add(new ArrayList<>());
        }

        Visit = new boolean[N + 1];

        min = new int[N + 1]; // 최단 거리를 담아두기 위한 배열

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(bf.readLine());

            int A = Integer.parseInt(st2.nextToken());
            int B = Integer.parseInt(st2.nextToken());

            Graph.get(A).add(B);
        }

        BFS(X);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (min[i] == K) {
                count++;
                bw.write(i + "\n");
            }
        }

        if (count == 0) {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
    }
}
