import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(bf.readLine());

            BigInteger sum = new BigInteger("0");

            for (int j = 0; j < N; j++) {
                BigInteger temp = new BigInteger(bf.readLine());

                sum = sum.add(temp);
            }

            BigInteger compare = new BigInteger("0");
            int result = sum.compareTo(compare);

            if (result == 0) {
                System.out.println(0);
            } else if (result == -1) {
                System.out.println("-");
            } else {
                System.out.println("+");
            }
        }
    }
}
