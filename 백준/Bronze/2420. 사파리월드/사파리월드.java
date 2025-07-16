import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long result = N - M;
        if (result < 0) {
            result *= -1;
        }

        System.out.println(result);
    }
}
