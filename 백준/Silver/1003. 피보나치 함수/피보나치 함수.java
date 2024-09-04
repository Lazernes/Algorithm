import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] fib0 = new int[41];
    static int[] fib1 = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        fib0[0] = 1;
        fib0[1] = 0;
        fib1[0] = 0;
        fib1[1] = 1;

        for (int i = 2; i < 41; i++) {
            fib0[i] = fib0[i - 1] + fib0[i - 2];
            fib1[i] = fib1[i - 1] + fib1[i - 2];
        }

        for (int i = 0; i < T; i++) {
            int a = Integer.parseInt(bf.readLine());
            System.out.println(fib0[a] + " " + fib1[a]);
        }
    }

}
