import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] Box;
    public static int White;
    public static int Blue;

    public static void Cut(int[][] arr) {
        boolean full = true;
        int color = arr[0][0];
        int iter = arr.length;

        for (int i = 0; i < iter; i++) {
            for (int j = 0; j < iter; j++) {
                if (arr[i][j] != color) {
                    full = false;
                }
            }
        }

        if (full) {
            if (color == 0) {
                White++;
            } else {
                Blue++;
            }
        } else {
            int[][] arr1 = new int[iter / 2][iter / 2];
            int[][] arr2 = new int[iter / 2][iter / 2];
            int[][] arr3 = new int[iter / 2][iter / 2];
            int[][] arr4 = new int[iter / 2][iter / 2];

            for (int i = 0; i < iter / 2; i++) {
                for (int j = 0; j < iter / 2; j++) {
                    arr1[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < iter / 2; i++) {
                for (int j = iter / 2; j < iter; j++) {
                    arr2[i][j - iter / 2] = arr[i][j];
                }
            }

            for (int i = iter / 2; i < iter; i++) {
                for (int j = 0; j < iter / 2; j++) {
                    arr3[i - iter / 2][j] = arr[i][j];
                }
            }

            for (int i = iter / 2; i < iter; i++) {
                for (int j = iter / 2; j < iter; j++) {
                    arr4[i - iter / 2][j - iter / 2] = arr[i][j];
                }
            }

            Cut(arr1);
            Cut(arr2);
            Cut(arr3);
            Cut(arr4);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bf.readLine());
        White = 0;
        Blue = 0;

        Box = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                Box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Cut(Box);

        bw.write(White + "\n" + Blue);
        bw.flush();
        bw.close();
    }
}
