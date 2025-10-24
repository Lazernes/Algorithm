import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int iter = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            System.out.println("Triangle #" + iter);

            if (a == -1) {
                double temp = c * c - b * b;
                if (temp > 0) {
                    System.out.printf("a = %.3f\n", Math.sqrt(temp));
                } else {
                    System.out.println("Impossible.");
                }
            } else if (b == -1) {
                double temp = c * c - a * a;
                if (temp > 0) {
                    System.out.printf("b = %.3f\n", Math.sqrt(temp));
                } else {
                    System.out.println("Impossible.");
                }
            } else if (c == -1) {
                double temp = a * a + b * b;
                if (temp > 0) {
                    System.out.printf("c = %.3f\n", Math.sqrt(temp));
                } else {
                    System.out.println("Impossible.");
                }
            }
            System.out.println();
            iter++;
        }
    }
}
