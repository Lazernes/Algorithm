import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visit;// 방문 배열

    public static void DFS(int V) {
        visit[V] = true;
        System.out.print(V + " ");

        for (int node : graph.get(V)) {
            if (!visit[node]) {
                DFS(node);
            }
        }

    }

    public static void BFS(int V) {
        Queue<Integer> qu = new LinkedList<>();

        qu.offer(V);
        visit[V] = true;

        while (!qu.isEmpty()) {
            int node = qu.poll();
            System.out.print(node + " ");
            for (int i = 0; i < graph.get(node).size(); i++) {
                int temp = graph.get(node).get(i);
                if (!visit[temp]) {
                    visit[temp] = true;
                    qu.offer(temp);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }   // 각 노드 별 리스트를 만들어준다.

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }   // Graph 완성

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        visit = new boolean[N + 1];

        DFS(V);
        Arrays.fill(visit, Boolean.FALSE);
        System.out.println();
        BFS(V);
    }
}
