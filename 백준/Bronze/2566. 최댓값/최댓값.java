import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int a = 0;
        int b = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 9; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp > max) {
                    max = temp;
                    a = i;
                    b = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((a + 1) + " " + (b + 1));
    }
}
