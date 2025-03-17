import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int temp = Integer.parseInt(bf.readLine());
            sum += temp;
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }
}
