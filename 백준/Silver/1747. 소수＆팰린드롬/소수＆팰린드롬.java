import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] number = new boolean[1005001];

    public static void Eratosthenes() {
        Arrays.fill(number, true);
        number[0] = false;
        number[1] = false;
        for (int i = 2; i < Math.sqrt(1005000); i++) {
            if (number[i]) {
                for (int j = i + i; j < 1005001; j += i) {
                    number[j] = false;
                }
            }
        }
    }

    public static boolean Pal(int a) {
        String aNumber = String.valueOf(a);
        String[] LR = aNumber.split("");
        boolean result = true;

        for (int i = aNumber.length() - 1; i >=0 ; i--) {
            if (!LR[aNumber.length() - i - 1].equals(LR[i])) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        Eratosthenes();
        int result = 0;

        for (int i = N; i <= 1005000; i++) {
            if (Pal(i) && number[i]) {
                result = i;
                break;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
