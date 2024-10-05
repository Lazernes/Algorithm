import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static Boolean[] arr;

    // 에라토스테네스의 채
    public static void isPrime(int a) {
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (arr[i]) {
                for (int j = i + i; j <= a; j += i) {
                    arr[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int rootB = (int) Math.sqrt(B);
        arr = new Boolean[rootB + 1];
        Arrays.fill(arr, true);
        isPrime(rootB);

        int count = 0;
        for (int i = 0; i <= rootB; i++) {
            if (arr[i]) {
                long temp = i;
                while (temp <= (double) B / i) {
                    if (temp >= (double) A / i) {
                        count++;
                    }

                    temp = temp * i;
                }

            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}