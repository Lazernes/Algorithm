import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        if (n >= 1000000) {
            System.out.println(n * 2 / 10 + " " +  n * 8 / 10);
        } else if (n >= 500000) {
            System.out.println(n * 15 / 100 + " " + n * 85 / 100);
        } else if (n >= 100000) {
            System.out.println(n / 10 + " " + n * 9 / 10);
        } else {
            System.out.println(n * 5 / 100 + " " + n * 95 / 100);
        }

    }
}