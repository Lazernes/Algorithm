import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int N;
    public static int[] count;
    public static int index;

    public static int[][] Map;
    public static boolean[][] Visit;

    public static void DFS(int i, int j) {
        count[index]++;
        Visit[i][j] = true;

        if (i > 0 && Map[i - 1][j] == 1 && !Visit[i - 1][j]) {
            DFS(i - 1, j);
        }

        if (i < N - 1 && Map[i + 1][j] == 1 && !Visit[i + 1][j]) {
            DFS(i + 1, j);
        }

        if (j > 0 && Map[i][j - 1] == 1 && !Visit[i][j - 1]) {
            DFS(i, j - 1);
        }

        if (j < N - 1 && Map[i][j + 1] == 1 && !Visit[i][j + 1]) {
            DFS(i, j + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        Map = new int[N][N];
        Visit = new boolean[N][N];

        index = 0;
        count = new int[N * N];

        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            for (int j = 0; j < N; j++) {
                int temp = input.charAt(j);
                temp -= '0';
                Map[i][j] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Map[i][j] == 1 && !Visit[i][j]) {
                    DFS(i, j);
                    index++;
                }
            }
        }

        Arrays.sort(count);
        System.out.println(index);
        for (int i = 0; i < N * N; i++) {
            if (count[i] != 0) {
                System.out.println(count[i]);
            }
        }
    }
}
