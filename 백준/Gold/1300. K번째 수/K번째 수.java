import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(bf.readLine());
        long K = Integer.parseInt(bf.readLine());

        long start = 1;
        long end = K;
        long ans = 0;

        while (start <= end) {
            long next = 0;
            long mid = (start + end) / 2;
            for (int i = 1; i <= N; i++) {
                long tmp = mid / i;
                if (tmp > N) {
                    tmp = N;
                }

                next += tmp;
            }

            if (next < K) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }

        }

        System.out.println(ans);


    }
}
