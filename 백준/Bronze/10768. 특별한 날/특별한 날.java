import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(bf.readLine());
        int D = Integer.parseInt(bf.readLine());

        if (M == 2 && D == 18) {
            System.out.println("Special");
        } else if (M < 2) {
            System.out.println("Before");
        } else if (M == 2 && D < 18) {
            System.out.println("Before");
        } else {
            System.out.println("After");
        }
        
    }
}
