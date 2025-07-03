import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int newN = N;
        int cycle = 0;

        do {
            newN = (newN % 10) * 10 + (newN / 10 + newN % 10) % 10;
            cycle++;
        } while (N != newN);

        System.out.println(cycle);
    }
}
