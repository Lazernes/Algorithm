import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] cup = new boolean[N + 1];
        cup[X] = true;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean temp = cup[a];
            cup[a] = cup[b];
            cup[b] = temp;
        }

        for (int i = 1; i < N + 1; i++) {
            if (cup[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
