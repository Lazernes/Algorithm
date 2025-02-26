import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        String temp = bf.readLine();
        int a = temp.length();

        String[] arr = new String[a];
        boolean[] result = new boolean[a];
        Arrays.fill(result, true);

        arr = temp.split("");

        for (int i = 1; i < N; i++) {
            String temp2 = bf.readLine();
            String[] arrTemp = new String[50];
            arrTemp = temp2.split("");

            for (int j = 0; j < a; j++) {
                if (!arr[j].equals(arrTemp[j])) {
                    result[j] = false;
                }
            }

        }

        for (int i = 0; i < a; i++) {
            if (result[i]) {
                bw.write(arr[i]);
            } else {
                bw.write("?");
            }
        }

        bw.flush();
        bw.close();
    }

}
