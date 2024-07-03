import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] TSize;
        TSize = new int[6];

        for (int i = 0; i < 6; i++) {
            TSize[i] = scanner.nextInt();
        }

        int T = scanner.nextInt();
        int P = scanner.nextInt();

        int TCount = 0;

        for (int i = 0; i < 6; i++) {
            int Ttemp = 0;
            if (TSize[i] % T == 0) {
                Ttemp = TSize[i] / T;
            } else {
                Ttemp = TSize[i] / T + 1;
            }

            TCount += Ttemp;
        }

        System.out.println(TCount);
        System.out.println(N / P + " " + N % P);
    }
}