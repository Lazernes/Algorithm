import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void LCM(int a, int b) {
        int a_temp = a;
        int b_temp = b;
        int temp = a_temp % b_temp;
        while (temp != 0) {
            a_temp = b_temp;
            b_temp = temp;
            temp = a_temp % b_temp;
        }

        int r = a / b_temp * b / b_temp * b_temp;
        System.out.println(r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            LCM(a, b);
        }
    }
}
