import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] number = new boolean[(int) (max - min + 1)];

        for (long i = 2; i <= Math.sqrt(max); i++) {
            long pow = i * i;
            long temp = min / pow;
            if (min % pow != 0) {
                temp++;
            }

            for (long j = temp; j * pow <= max; j++) {
                number[(int) (j * pow - min)] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < max - min + 1; i++) {
            if (!number[i]) {
                result++;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();

    }
}
