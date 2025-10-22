import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int max = -1000000;
            int min = 1000000;

            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp > max) {
                    max = temp;
                }

                if (temp < min) {
                    min = temp;
                }
            }

            System.out.println(min + " " + max);
        }
    }
}
