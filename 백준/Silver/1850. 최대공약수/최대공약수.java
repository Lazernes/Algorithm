import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void GCD(long a, long b) throws IOException {
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }

        long remain = a % b;
        while (remain != 0) {
            a = b;
            b = remain;
            remain = a % b;
        }

        for (int i = 0; i < b; i++) {
            bw.write(1 + "");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        GCD(A, B);

        bw.flush();
        bw.close();
    }
}
