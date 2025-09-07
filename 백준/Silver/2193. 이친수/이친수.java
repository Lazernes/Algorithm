import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static long[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        D = new long[N + 1][2];
        D[1][0] = 0;
        D[1][1] = 1;

        for (int i = 2; i < N + 1; i++) {
            D[i][0] = D[i - 1][1] + D[i - 1][0];
            D[i][1] = D[i - 1][0];
        }
        
        System.out.println(D[N][1] + D[N][0]);
    }
}
