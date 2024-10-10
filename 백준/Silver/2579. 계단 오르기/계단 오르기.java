import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int[] stair = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(bf.readLine());
        }

        int[][] arr = new int[N + 1][N + 1];

        arr[0][1] = stair[1];

        if (N >= 2) {
            arr[0][2] = stair[2];
            arr[1][2] = arr[0][1] + stair[2];
        }

        if (N >= 3) {
            arr[1][3] = arr[0][1] + stair[3];
        }

        for (int i = 2; i < N; i++) {
            // i에서 i + 1으로 이동
            arr[i][i + 1] = arr[i - 2][i] + stair[i + 1];

            // i에서 i + 2로 이동
            if (i < N - 1) {
                int temp = arr[i-2][i] > arr[i-1][i] ? arr[i - 2][i] : arr[i - 1][i];
                arr[i][i + 2] = temp + stair[i + 2];
            }
        }
        
        // N = 1 때, default값으로 설정
        int result = arr[0][1];

        if (N > 1) {
            result = arr[N - 2][N] > arr[N - 1][N] ? arr[N - 2][N] : arr[N - 1][N];
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
