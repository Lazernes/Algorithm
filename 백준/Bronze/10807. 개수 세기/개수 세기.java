import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[201];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (temp >= 0) {
                arr[temp]++;
            } else {
                arr[100 - temp]++;
            }
        }

        int v = Integer.parseInt(bf.readLine());

        if (v < 0) {
            System.out.println(arr[100 - v]);
        } else {
            System.out.println(arr[v]);
        }
    }

}
