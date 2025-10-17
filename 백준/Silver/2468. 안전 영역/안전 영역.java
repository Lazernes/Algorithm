import java.io.*;
import java.util.*;

public class Main {

    static int[][] M;
    static boolean[][] Visit;
    static int N;
    static int h;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void BFS(int a, int b) { // 상하좌우로 BFS

        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(a, b));
        Visit[a][b] = true;

        while (!qu.isEmpty()) {
            Node currentNode = qu.poll();
            int currentA = currentNode.a;
            int currentB = currentNode.b;
            
            for (int i = 0; i < 4; i++) {
               int nx = currentA + dx[i];
               int ny = currentB + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!Visit[nx][ny] && M[nx][ny] > h) {
                        Visit[nx][ny] = true;
                        qu.add(new Node(nx, ny));
                    }
                }
            }

        }

    }

    public static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int Max = 0;

        for (h = 0; h <= 100; h++) {
            int count = 0;
            Visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!Visit[i][j] && M[i][j] > h) {
                        BFS(i, j);
                        count++;
                    }
                }
            }

            if (count > Max) {
                Max = count;
            }
        }

        System.out.println(Max);
    }
}
