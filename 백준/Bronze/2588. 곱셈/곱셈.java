import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());

        int tempB = b;
        System.out.println(a * (tempB % 10));
        tempB /= 10;
        System.out.println(a * (tempB % 10));
        tempB /= 10;
        System.out.println(a * (tempB % 10));
        System.out.println(a * b);
    }
}