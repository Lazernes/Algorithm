import java.io.*;

public class Main {

    public static int factorial(int a) {
        int result = 1;
        for (int i = 1; i <= a; i++) {
            result = result * i;
        }

        return result;
    }

    public static int OneTwoThree(int n) {

        int sum = 0;
        for (int i = 0; i <= n; i++) {
            int temp = n - i;
            for (int j = 0; j <= temp / 2; j++) {
                int temp2 = temp - j * 2;
                if (temp2 % 3 == 0) {
                    int result = factorial(i + j + (temp2 / 3)) / (factorial(i) * factorial(j) * factorial(temp2 / 3));
                    sum += result;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            bw.write(OneTwoThree(Integer.parseInt(bf.readLine())) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
