import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] T;
    public static int[] P;
    public static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        T = new int[16];
        P = new int[16];
        D = new int[17];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) {
                D[i] = D[i + 1];
            } else {
                D[i] = Math.max(D[i + 1], P[i] + D[i + T[i]]);
            }
        }
        System.out.println(D[1]);
    }
}
