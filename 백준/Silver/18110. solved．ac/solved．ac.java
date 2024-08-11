import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        
        if (n == 0) {
            System.out.println(0);
        } else {
            int diff[];
            diff = new int[n];
            for (int i = 0; i < n; i++) {
                diff[i] = Integer.parseInt(bf.readLine());
            }
            Arrays.sort(diff);

            int tempint = (int) Math.round(n * 0.15);

            int sum = 0;
            for (int i = tempint; i < n - tempint; i++) {
                sum = sum + diff[i];
            }

            int result = (int)Math.round((double) sum / (n - 2 * tempint));
            System.out.println(result);
        }

    }
}
