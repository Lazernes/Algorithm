import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (name.equals("#")) {
                break;
            }

            if (age > 17 || weight >= 80) {
                bw.write(name + " Senior");
            } else {
                bw.write(name + " Junior");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
