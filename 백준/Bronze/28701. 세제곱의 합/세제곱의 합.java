import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        long answer1 = 0;
        long answer2 = 0;
        long answer3 = 0;

        for (long i = 1; i < N + 1; i++) {
            answer1 += i;
            answer3 += i * i * i;
        }

        answer2 = answer1 * answer1;

        bw.write(answer1 + "\n");
        bw.write(answer2 + "\n");
        bw.write(answer3 + "\n");

        bw.flush();
        bw.close();
    }
}
