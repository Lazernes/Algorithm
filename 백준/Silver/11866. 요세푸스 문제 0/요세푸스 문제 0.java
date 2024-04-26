import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<String>();

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            list.add(Integer.toString(i));
        }

        ArrayList<String> result = new ArrayList<String>();

        list.addFirst("first");
        list.addLast("last");

        int iter = K - 1;

        result.add(list.get(K));
        list.remove(K);

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < iter; j++) {
                if (list.get(K) != "last") {
                    K++;
                } else {
                    K = 2;
                }

                if (list.get(K) == "last") {
                    K = 1;
                }
            }
            result.add(list.get(K));
            list.remove(K);
        }

        System.out.print("<");
        for (int i = 0; i < N; i++) {
            if (i != N - 1) {
                System.out.print(result.get(i) + ", ");
            } else {
                System.out.print(result.get(i) + ">");
            }

        }

    }
}
