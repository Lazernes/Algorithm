import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    public static int[] depth;
    public static int[] parent;
    public static boolean[] visited;

    public static void BFS(int index) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(index);
        visited[index] = true;

        int level = 1;
        int currentSize = 1;
        int count = 0;

        while (!qu.isEmpty()) {
            int current = qu.poll();

            for (int next : tree.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    qu.add(next);
                    parent[next] = current;
                    depth[next] = level;
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

    public static int LCA(int A, int B) {

        // 깊이 동일하기 하기
        if (depth[A] < depth[B]) {
            int temp = A;
            A = B;
            B = temp;
        }

        while (depth[A] != depth[B]) {
            A = parent[A];
        }

        // 깊이가 같아졌으므로 동시에 부모 노드 찾기
        while (A != B) {
            A = parent[A];
            B = parent[B];
        }
        return A;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            tree.get(A).add(B);
            tree.get(B).add(A);
        }

        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        BFS(1);

        int M = Integer.parseInt(bf.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            System.out.println(LCA(A, B));
        }

    }
}
