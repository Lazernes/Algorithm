import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static boolean[] visit;
    public static int[] depth;
    public static int[][] parent;
    public static int kMax;

    public static void BFS(int node) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(node);
        visit[node] = true;

        int level = 1;
        int currentSize = 1;
        int count = 0;

        while (!qu.isEmpty()) {
            int currentNode = qu.poll();

            for (int nextNode : tree.get(currentNode)) {
                if (!visit[nextNode]) {
                    qu.add(nextNode);
                    visit[nextNode] = true;
                    parent[0][nextNode] = currentNode;
                    depth[nextNode] = level;
                }
            }

            count++;
            if (count == currentSize) {
                count = 0;
                currentSize = qu.size();
                level++;
            }
        }
    }

    public static int LCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // depth 맞추기
        for (int k = kMax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }

        // 최소 공통 조상 찾기
        for (int k = kMax; k >= 0 && a != b; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        int result = a;
        if (a != b) {
            result = parent[0][result];
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        visit = new boolean[N + 1];
        depth = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // K의 최대값 구하기
        int temp = 1;
        kMax = 0;
        while (temp < N) {
            temp *= 2;
            kMax++;
        }

        parent = new int[kMax + 1][N + 1];

        BFS(1);

        // P[K][N] = P[K - 1][P[k - 1][N]]
        for (int k = 1; k <= kMax; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(LCA(a, b));
        }

    }
}
