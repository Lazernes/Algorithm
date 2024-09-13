import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 1];

        if (N >= 2) {
            arr[2] = 1;
        }

        if (N >= 3) {
            arr[3] = 1;
        }

        for (int i = 4; i < N + 1; i++) {
            int[] tmp = new int[3];

            if (i % 2 == 0) {
                tmp[0] = arr[i / 2] + 1;
            }
            if (i % 3 == 0) {
                tmp[1] = arr[i / 3] + 1;
            }
            tmp[2] = arr[i - 1] + 1;

            Arrays.sort(tmp);

            for (int j = 0; j < 3; j++) {
                if (tmp[j] != 0) {
                    arr[i] = tmp[j];
                    break;
                }
            }

        }

        bw.write(arr[N] + "\n");
        bw.flush();
        bw.close();
    }
}
