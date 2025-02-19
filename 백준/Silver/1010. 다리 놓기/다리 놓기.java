import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void Combination(int N, int M) {

        long result = 1;

        for (int i = 0; i < N; i++) {
            result = result * (M - i) / (i + 1);
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Combination(N, M);
        }
    }

}
