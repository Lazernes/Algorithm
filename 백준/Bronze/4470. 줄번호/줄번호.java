import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 1; i < N + 1; i++) {
            String input = bf.readLine();
            System.out.println(i + ". " + input);
        }
    }
}
