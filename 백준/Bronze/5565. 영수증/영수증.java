import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int totalPrice = Integer.parseInt(bf.readLine());

        for (int i = 0; i < 9; i++) {
            int price = Integer.parseInt(bf.readLine());

            totalPrice -= price;
        }

        System.out.println(totalPrice);
    }
}
