import java.util.*;

public class Main {

    static int V;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> weight = new ArrayList<>();

    static boolean[] visit; // 방문 배열
    static int[] max;   // 지름을 구하기 위한 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            weight.add(new ArrayList<>());
        }   // 각 노드 별 리스트를 만들어준다.

        visit = new boolean[V + 1];
        max = new int[V + 1];

        for (int i = 0; i < V; i++) {
            int start = sc.nextInt();
            while (true) {
                int node = sc.nextInt();
                if (node == -1) {
                    break;
                }

                graph.get(start).add(node);

                int tmpweight = sc.nextInt();
                weight.get(start).add(tmpweight);
            }
        }   // 트리 정보 입력

        BFS(2);

        int restart = 1;
        for (int i = 1; i <= V; i++) {
            int tmp = max[i];
            if (tmp > max[restart]) {
                restart = i;
            }
        }

        Arrays.fill(max, 0);
        BFS(restart);
        restart = 1;
        for (int i = 1; i <= V; i++) {
            int tmp = max[i];
            if (tmp > max[restart]) {
                restart = i;
            }
        }
        System.out.println(max[restart]);

    }

    public static void BFS(int start) {
        Arrays.fill(visit, false);

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);

        while (!qu.isEmpty()) {
            int node = qu.poll();
            visit[node] = true;
            for (int i = 0; i < graph.get(node).size(); i++) {
                int nextNode = graph.get(node).get(i);
                if (!visit[nextNode]) {
                    qu.offer(nextNode);
                    max[nextNode] = max[node] + weight.get(node).get(i);
                }
            }
        }


    }
}
