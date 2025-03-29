import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static long[] Tree;
    public static int k;

    public static void AddData(int N) throws IOException {
        int index = (int) Math.pow(2, k);
        for (int i = 0; i < N; i++) {
            long data = Long.parseLong(bf.readLine());
            Tree[index] = data;
            index++;
        }
    }

    public static void ChangeData(int changeIndex, long data) {
        int index = (int) (changeIndex + (Math.pow(2, k) - 1));
        long diff = data - Tree[(int) ((Math.pow(2, k) - 1) + changeIndex)];
        while (index > 0) {
            Tree[index] += diff;
            index = index / 2;
        }
    }

    public static void SumData(int startIndex, int endIndex) throws IOException {
        startIndex = (int) (startIndex + (Math.pow(2, k) - 1));
        endIndex = (int) (endIndex + (Math.pow(2, k) - 1));

        long sum = 0;
        while (startIndex <= endIndex) {
            if (startIndex % 2 == 1) {
                sum += Tree[startIndex];
            }

            if (endIndex % 2 == 0) {
                sum += Tree[endIndex];
            }

            startIndex = (startIndex + 1) / 2;
            endIndex = (endIndex - 1) / 2;
        }

        bw.write(sum + "\n");
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // k값 구하기
        k = 0;
        while (Math.pow(2, k) < N) {
            k++;
        }
        Tree = new long[(int) Math.pow(2, k) * 2];

        // 기존 데이터 채우기
        AddData(N);

        // 세그먼트 트리 채우기
        for (int i = (int) (Math.pow(2, k) - 1); i > 0; i--) {
            Tree[i] = Tree[2 * i] + Tree[2 * i + 1];
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                ChangeData(b, c);
            } else if (a == 2) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                SumData(b, c);
            }
        }

        bw.flush();
        bw.close();
    }
}
