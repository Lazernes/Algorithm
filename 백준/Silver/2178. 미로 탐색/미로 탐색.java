import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    public static int[] x = {-1, 1, 0, 0};
    public static int[] y = {0, 0, -1, 1};
    // 현재 위치에서 4방향을 검사하기 위해 사용하는 배열

    public static class Pair<A, B> {
        private A first;
        private B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] maze = new int[N + 1][M + 1];
        boolean[][] visit = new boolean[N + 1][M + 1];
        Queue<Pair<Integer, Integer>> qu = new LinkedList<>(); // BFS를 위한 Queue

        for (int i = 1; i <= N; i++) {
            String[] StrArr = sc.next().split("");

            for (int j = 1; j <= M; j++) {
                maze[i][j] = Integer.parseInt(StrArr[j - 1]);
            }
        }   // 공백없이 입력 받을 때 나누는 방법

        qu.offer(new Pair(1, 1));
        visit[1][1] = true; // (1,1)에서 시작

        while (!qu.isEmpty()) {
            Pair temp = qu.poll();
            int current_x = (int) temp.first;
            int current_y = (int) temp.second;

            for (int i = 0; i < 4; i++) {
                int next_x = current_x + x[i];
                int next_y = current_y + y[i];

                if (next_x <= N && next_y <= M) {
                    if (!visit[next_x][next_y] && maze[next_x][next_y] != 0) {
                        qu.offer(new Pair(next_x, next_y));
                        visit[next_x][next_y] = true;
                        maze[next_x][next_y] = maze[current_x][current_y] + 1;
                    }
                }

            }
        }

        System.out.println(maze[N][M]);
    }
}
