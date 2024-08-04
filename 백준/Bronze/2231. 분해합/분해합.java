import java.util.Scanner;

public class Main {

    public static int Gen(int a) {

        int result = a;
        while (a != 0) {
            result = result + a % 10;
            a = a / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int min = 0;
        int iter = 0;

        while (min != N) {
            iter++;

            if (iter >= N) {
                iter = 0;
                break;
            }

            min = Gen(iter);
        }

        System.out.println(iter);
    }
}
