import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int M;
    public static int INum; // 섬 번호
    public static int[][] Sea;
    public static ArrayList<ArrayList<Position>> Island;    // 섬 정보 저장
    public static boolean[][] Visit;    // BFS를 위한 Visit 배열
    public static PriorityQueue<Edge> pq;

    public static void BFS(int a, int b) {
        Queue<Position> qu = new LinkedList<>();
        Island.get(INum).add(new Position(a, b));
        qu.add(new Position(a, b));
        Visit[a][b] = true;
        Sea[a][b] = INum;

        while (!qu.isEmpty()) {
            Position cur = qu.poll();
            int curX = cur.x;   // 세로축
            int curY = cur.y;   // 가로축

            if (curX > 0 && Sea[curX - 1][curY] == 1 && !Visit[curX - 1][curY]) {
                Sea[curX - 1][curY] = INum;
                Visit[curX - 1][curY] = true;
                Island.get(INum).add(new Position(curX - 1, curY));
                qu.add(new Position(curX - 1, curY));
            }   // 상
            if (curX < N - 1 && Sea[curX + 1][curY] == 1 && !Visit[curX + 1][curY]) {
                Sea[curX + 1][curY] = INum;
                Visit[curX + 1][curY] = true;
                Island.get(INum).add(new Position(curX + 1, curY));
                qu.add(new Position(curX + 1, curY));
            }
            if (curY > 0 && Sea[curX][curY - 1] == 1 && !Visit[curX][curY - 1]) {
                Sea[curX][curY - 1] = INum;
                Visit[curX][curY - 1] = true;
                Island.get(INum).add(new Position(curX, curY - 1));
                qu.add(new Position(curX, curY - 1));
            }
            if (curY < M - 1 && Sea[curX][curY + 1] == 1 && !Visit[curX][curY + 1]) {
                Sea[curX][curY + 1] = INum;
                Visit[curX][curY + 1] = true;
                Island.get(INum).add(new Position(curX, curY + 1));
                qu.add(new Position(curX, curY + 1));
            }

        }
    }

    public static int[] arr;    // 유니온 파인드를 위한 배열

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

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Sea = new int[N][M];
        Visit = new boolean[N][M];
        INum = 1;
        pq = new PriorityQueue<>(); // 최소 신장 트리를 위한 PQ

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < M; j++) {
                Sea[i][j] = Integer.parseInt(st.nextToken());
            }
        }   // 섬 정보 저장

        Island = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Island.add(new ArrayList<>());
        }   // 섬의 개수는 최대 6개 이므로 7까지 add

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Sea[i][j] == 1 && !Visit[i][j]) {
                    BFS(i, j);
                    INum++;
                }
            }
        }

        int[] D1 = new int[]{-1, 0, 1, 0};
        int[] D2 = new int[]{0, -1, 0, 1};

        for (int i = 1; i < INum; i++) {
            for (int j = 0; j < Island.get(i).size(); j++) {
                Position current = Island.get(i).get(j);
                int currentX = current.x;
                int currentY = current.y;

                // 4방향 탐색
                for (int k = 0; k < 4; k++) {
                    int temp1 = D1[k];  // 상하
                    int temp2 = D2[k];  // 좌우
                    int Bridge = 0;

                    while (currentX + temp1 >= 0 && currentX + temp1 < N && currentY + temp2 >= 0 && currentY + temp2 < M) {
                        if (Sea[currentX + temp1][currentY + temp2] == INum) {
                            break;
                        }

                        if (Sea[currentX + temp1][currentY + temp2] != 0) {
                            if (Bridge > 1) {
                                pq.add(new Edge(i, Sea[currentX+temp1][currentY+temp2], Bridge));
                            }
                            break;
                        } else {
                            Bridge++;
                        }

                        if (temp1 < 0) {
                            temp1--;
                        } else if (temp1 > 0) {
                            temp1++;
                        } else if (temp2 < 0) {
                            temp2--;
                        } else if (temp2 > 0) {
                            temp2++;
                        }
                    }
                }
            }
        }   // 최소 신장 트리를 위한 PQ 생성

        // 최소 신장 트리 알고리즘 사용
        arr = new int[INum];
        for (int i = 1; i < INum; i++) {
            arr[i] = i;
        }

        int answer = 0;
        int connectedIsland = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (find(current.start) != find(current.end)) {
                union(current.start, current.end);
                answer += current.weight;
                connectedIsland++;
            }
        }

        if (connectedIsland == INum - 2) {
            bw.write(answer + "\n");
        } else {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
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
