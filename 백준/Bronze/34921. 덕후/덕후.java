import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int P = 10 + 2 * (25 - Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
        P = P < 0 ? 0 : P;
        System.out.println(P);
    }
}