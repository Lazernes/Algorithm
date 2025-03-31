import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
        }

        Arrays.sort(arr);
        for (int i = 0; i < 3; i++) {
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
