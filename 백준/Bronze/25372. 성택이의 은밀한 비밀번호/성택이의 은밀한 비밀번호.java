import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String input = bf.readLine();

            if (input.length() >= 6 && input.length() <= 9) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }
}