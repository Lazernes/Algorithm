import java.util.Scanner;

public class Main {

    public static int num(int k, int n) {
        int[][] arr;
        arr = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 0) {
                    arr[i][j] = j;
                } else if (j == 1) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                }
            }
        }

        return arr[k][n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(num(k, n));
        }
    }
}
