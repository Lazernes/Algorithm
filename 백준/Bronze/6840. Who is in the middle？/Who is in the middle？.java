import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];

        arr[0]=Integer.parseInt(bf.readLine());
        arr[1]=Integer.parseInt(bf.readLine());
        arr[2]=Integer.parseInt(bf.readLine());

        Arrays.sort(arr);
        System.out.println(arr[1]);

    }
}