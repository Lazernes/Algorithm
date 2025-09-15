import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = 0;
        int T = 0;
        for (int i = 0; i < 4; i++) {
            int score = Integer.parseInt(st.nextToken());
            S += score;
        }

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < 4; i++) {
            int score = Integer.parseInt(st.nextToken());
            T += score;
        }

        if (S >= T) {
            System.out.println(S);
        } else {
            System.out.println(T);
        }

    }
}
