import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        arr = new boolean[N + 1];
        Prime();

        for (int i = M; i <= N; i++) {
            if (!arr[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void Prime() {
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = i * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
    }
}
