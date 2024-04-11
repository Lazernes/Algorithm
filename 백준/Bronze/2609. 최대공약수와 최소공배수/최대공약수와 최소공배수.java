import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        ArrayList<Integer> div = new ArrayList<>();
        int commul = 1;

        int iter = 1;

        while (true) {
            if (iter > A || iter > B) {
                break;
            }

            if (iter == 1) {
                if (A == 1 || B == 1) {
                    commul = A * B;
                    div.add(iter);
                }
            } else if (A % iter == 0 && B % iter == 0) {
                A = A / iter;
                B = B / iter;
                div.add(iter);
                commul = A * B;
                iter = 1;
            }

            iter++;
        }

        if (div.size() == 0) {
            commul = A * B;
        } // 서로소일 때

        int comdiv = 1;
        for (int i = 0; i < div.size(); i++) {
            comdiv = comdiv * div.get(i);
        }
        System.out.println(comdiv);
        System.out.println(commul * comdiv);

    }
}