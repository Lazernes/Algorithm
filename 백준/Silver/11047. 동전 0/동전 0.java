import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(bf.readLine());
        }

        int result = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (coin[i] <= K) {
                result += (K / coin[i]);
                K = K % coin[i];
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
