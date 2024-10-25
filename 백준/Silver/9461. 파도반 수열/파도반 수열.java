import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine());

        long[] tra = new long[101];
        tra[0] = 0;
        tra[1] = 1;
        tra[2] = 1;
        tra[3] = 1;
        tra[4] = 2;
        tra[5] = 2;

        for (int i = 6; i < 101; i++) {
            tra[i] = tra[i - 1] + tra[i - 5];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            bw.write(tra[N] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
