import java.io.*;

public class Main {

    public static int N;
    public static int[][] Map;

    public static int Search(int i, int j) {

        int sum = 0;

        if (i > 0) {
            sum += Map[i - 1][j];

            if (j > 0) {
                sum += Map[i - 1][j - 1];
            }

            if (j < N - 1) {
                sum += Map[i - 1][j + 1];
            }
        }

        if (i < N - 1) {
            sum += Map[i + 1][j];

            if (j > 0) {
                sum += Map[i + 1][j - 1];
            }

            if (j < N - 1) {
                sum += Map[i + 1][j + 1];
            }

        }

        if (j > 0) {
            sum += Map[i][j - 1];
        }

        if (j < N - 1) {
            sum += Map[i][j + 1];
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(bf.readLine());

        Map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = bf.readLine();

            for (int j = 0; j < N; j++) {
                int current = input.charAt(j);

                if (current == '.') {
                    Map[i][j] = 0;
                } else {
                    current -= 48;
                    Map[i][j] = current;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int current = Map[i][j];

                if (current > 0) {
                    System.out.print("*");
                } else {
                    int search = Search(i, j);

                    if (search >= 10) {
                        System.out.print("M");
                    } else {
                        System.out.print(search);
                    }
                }
            }
            System.out.println();
        }
    }
}
