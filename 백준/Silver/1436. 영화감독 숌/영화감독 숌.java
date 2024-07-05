import java.util.Scanner;

public class Main {

    public static boolean IsEnd(int number) {
        int temp = 2;
        int pow = 10 * 10;
        while (number / pow != 0) {
            temp++;
            pow = pow * 10;
        }

        int[] Arr;
        Arr = new int[temp];
        for (int i = temp - 1; i >= 0; i--) {
            pow = pow / 10;
            Arr[i] = number / pow;
            number = number - Arr[i] * pow;
        }

        boolean result = false;

        for (int i = 0; i < temp - 2; i++) {
            if (Arr[i] == 6 && Arr[i + 1] == 6 && Arr[i + 2] == 6) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();

        int N = 1;
        int number = 666;

        while (N != target) {
            number++;

            if (IsEnd(number)) {
                N++;
            }
        }

        System.out.println(number);
    }
}
