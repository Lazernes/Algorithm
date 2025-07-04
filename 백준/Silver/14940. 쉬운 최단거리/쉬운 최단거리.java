import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;

    public static int[][] Map;
    public static int[][] Distance;

    public static void BFS(Node node) {
        Queue<Node> qu = new LinkedList<>();

        qu.offer(node);

        while (!qu.isEmpty()) {
            Node cN = qu.poll();    // currentNode

            if (cN.x < n - 1 && Map[cN.x + 1][cN.y] > 0) {  // 상
                if (Distance[cN.x + 1][cN.y] > Distance[cN.x][cN.y] + 1) {
                    Distance[cN.x + 1][cN.y] = Distance[cN.x][cN.y] + 1;
                    qu.offer(new Node(cN.x + 1, cN.y));
                }
            }

            if (cN.x > 0 && Map[cN.x - 1][cN.y] > 0) {  // 하
                if (Distance[cN.x - 1][cN.y] > Distance[cN.x][cN.y] + 1) {
                    Distance[cN.x - 1][cN.y] = Distance[cN.x][cN.y] + 1;
                    qu.offer(new Node(cN.x - 1, cN.y));
                }
            }

            if (cN.y > 0 && Map[cN.x][cN.y - 1] > 0) {  // 좌
                if (Distance[cN.x][cN.y - 1] > Distance[cN.x][cN.y] + 1) {
                    Distance[cN.x][cN.y - 1] = Distance[cN.x][cN.y] + 1;
                    qu.offer(new Node(cN.x, cN.y - 1));
                }
            }

            if (cN.y < m - 1 && Map[cN.x][cN.y + 1] > 0) {  // 우
                if (Distance[cN.x][cN.y + 1] > Distance[cN.x][cN.y] + 1) {
                    Distance[cN.x][cN.y + 1] = Distance[cN.x][cN.y] + 1;
                    qu.offer(new Node(cN.x, cN.y + 1));
                }
            }


        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map = new int[n][m];
        Distance = new int[n][m];

        Node start = new Node(0, 0);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
                Distance[i][j] = Integer.MAX_VALUE;

                if (Map[i][j] == 2) {
                    start.x = i;
                    start.y = j;
                    Distance[i][j] = 0;
                } else if (Map[i][j] == 0) {
                    Distance[i][j]=0;
                }
            }
        }

        BFS(start);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Distance[i][j] == Integer.MAX_VALUE) {
                    Distance[i][j] = -1;
                }
                bw.write(Distance[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}