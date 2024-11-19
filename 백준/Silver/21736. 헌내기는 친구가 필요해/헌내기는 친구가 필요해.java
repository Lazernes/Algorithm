import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;

    public static int count;

    public static String[][] campus;
    public static boolean[][] visit;

    public static void findFriends(int x, int y) {

        if (visit[x][y]) {
            return;
        }   // 해당 좌표를 방문했다면 return

        visit[x][y] = true;

        if (campus[x][y].equals("P")) {
            count++;
        }
        if (x > 0 && !campus[x - 1][y].equals("X")) {
            findFriends(x - 1, y);
        }   // 상

        if (x < N - 1 && !campus[x + 1][y].equals("X")) {
            findFriends(x + 1, y);
        }   // 하

        if (y > 0 && !campus[x][y - 1].equals("X")) {
            findFriends(x, y - 1);
        }   // 좌

        if (y < M - 1 && !campus[x][y + 1].equals("X")) {
            findFriends(x, y + 1);
        }   // 우




    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = 0;

        campus = new String[N][M];
        visit = new boolean[N][M];

        int curX = 0;
        int curY = 0;

        for (int i = 0; i < N; i++) {
            String temp = bf.readLine();
            String[] tempArr = temp.split("");

            for (int j = 0; j < M; j++) {
                campus[i][j] = tempArr[j];

                if (campus[i][j].equals("I")) {
                    curX = i;
                    curY = j;
                }
            }
        }

        findFriends(curX, curY);

        if (count == 0) {
            bw.write("TT");
        } else {
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}
