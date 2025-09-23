import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int total = L * P;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 5; i++) {
            int person = Integer.parseInt(st.nextToken());
            System.out.print(person - total + " ");
        }
    }
}
