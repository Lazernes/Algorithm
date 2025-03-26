import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] Dice = new int[7];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int answer = 0;
        if (A == B && B == C) {
            answer = 10000 + A * 1000;
        } else if (A == B || B == C || C == A) {
            if (A == B) {
                answer = 1000 + A * 100;
            } else if (B == C) {
                answer = 1000 + B * 100;
            } else if (C == A) {
                answer = 1000 + C * 100;
            }
        } else {
            int max = A;
            if (B > max) {
                max = B;
            }
            if (C > max) {
                max = C;
            }

            answer = max * 100;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
