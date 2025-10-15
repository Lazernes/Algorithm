import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int used = 0;

        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            String[] temp = input.split("-");

            int D = Integer.parseInt(temp[1]);

            if (D <= 90) {
                used++;
            }
        }

        System.out.println(used);

    }
}
