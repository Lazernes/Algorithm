import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int X;
    public static int Y;

    public static boolean[][] Farm;
    public static boolean[][] Visit;

    public static void Graph(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            Farm[a][b] = true;
        }
    }

    public static void next(int a, int b) {
        if (a - 1 >= 0) {
            if (!Visit[a - 1][b] && Farm[a - 1][b]) {
                Visit[a - 1][b] = true;
                next(a - 1, b);
            }
        }

        if (a + 1 < X) {
            if (!Visit[a + 1][b] && Farm[a + 1][b]) {
                Visit[a + 1][b] = true;
                next(a + 1, b);
            }
        }

        if (b - 1 >= 0) {
            if (!Visit[a][b - 1] && Farm[a][b - 1]) {
                Visit[a][b - 1] = true;
                next(a, b - 1);
            }
        }

        if (b + 1 < Y) {
            if (!Visit[a][b + 1] && Farm[a][b + 1]) {
                Visit[a][b + 1] = true;
                next(a, b + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Farm = new boolean[X][Y];
            Visit = new boolean[X][Y];

            int A = Integer.parseInt(st.nextToken());
            Graph(A);

            int count = 0;

            for (int j = 0; j < X; j++) {
                for (int k = 0; k < Y; k++) {
                    if (Farm[j][k] && !Visit[j][k]) {
                        next(j, k);
                        count++;
                    }
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}
