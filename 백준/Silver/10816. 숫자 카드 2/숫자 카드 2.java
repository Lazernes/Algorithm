import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] getarr;
        getarr = new int[20000001];

        String s1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(s1);

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st1.nextToken());
            if (temp < 0) {
                temp = -temp + 10000000;
                getarr[temp]++;
            }
            else{
                getarr[temp]++;
            }
        }

        int M = Integer.parseInt(br.readLine());

        String s2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s2);

        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st2.nextToken());
            if (temp < 0) {
                temp = -temp + 10000000;
            }

            sb.append(getarr[temp]).append(' ');
//            System.out.print(getarr[temp] + " ");
        }
        System.out.println(sb);
        br.close();
    }
}

