import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] line = new long[K];
        long upper = 0;
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(bf.readLine());
            if (line[i] > upper) {
                upper = line[i];
            }
        }

        long result = 0;
        long bottom = 1;
        long mid = 0;

        while (bottom <= upper) {
            // Binary Search
            mid = (bottom + upper) / 2;
            result = 0;
            for (int i = 0; i < K; i++) {
                result = result + line[i] / mid;
            }

            if (result < N) {
                upper = mid - 1;
            } else {
                bottom = mid + 1;
            }
        }

        bw.write(String.valueOf(upper));
        bw.flush();
        bw.close();

    }
}
