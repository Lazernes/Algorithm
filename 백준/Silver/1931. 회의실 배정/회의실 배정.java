import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int[][] useTime = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            useTime[i][0] = Integer.parseInt(st.nextToken());
            useTime[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(useTime, Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt(o -> o[0]));
        // 두번째 숫자 기준으로 오름차순

        int eTime = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (useTime[i][0] >= eTime) {
                eTime = useTime[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}