import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int sum = 300;
        for (int i = 0; i < 4; i++) {
            sum+=Integer.parseInt(bf.readLine());
        }

        if (sum <= 1800) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}