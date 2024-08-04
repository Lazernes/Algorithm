import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int r = 31;
        int M = 1234567891;

        int L = sc.nextInt();
        String st = sc.next();

        int a[];
        a = new int[L];

        for (int i = 0; i < L; i++) {
            char tmp = st.charAt(i);
            a[i] = tmp - 96;
        }

        double result = 0;
        for (int i = 0; i < L; i++) {
            result = result + a[i] * Math.pow(r, i);
        }

        result = result % M;

        System.out.println((int)result);
    }
}
