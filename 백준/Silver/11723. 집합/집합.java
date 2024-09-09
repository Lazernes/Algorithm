import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(bf.readLine());
        boolean[] result = new boolean[21];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String op = st.nextToken();
            int num = 0;

            switch (op) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    result[num] = true;
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    result[num] = false;
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if(result[num])
                        bw.write(1 + "\n");
                    else
                        bw.write(0 + "\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if (result[num]) {
                        result[num] = false;
                    } else {
                        result[num] = true;
                    }
                    break;
                case "all":
                    Arrays.fill(result, true);
                    break;
                case "empty":
                    Arrays.fill(result, false);
                    break;
            }
        }

        bw.flush();
        bw.close();
    }

}
