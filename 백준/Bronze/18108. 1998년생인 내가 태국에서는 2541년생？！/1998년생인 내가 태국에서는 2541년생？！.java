import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int y = Integer.parseInt(bf.readLine());
        int diff = 2541 - 1998;

        System.out.println(y - diff);
    }
}
