import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static long[] Tree;
    public static int k;

    public static long Mod(long a, long b) {
        long result = ((a % 1000000007) * (b % 1000000007)) % 1000000007;

        return result;
    }

    public static void ChangeTree(int index, int value) {
        index = (int) (index + (Math.pow(2, k) - 1));
        Tree[index] = value;

        while (index > 1) {
            index = index / 2;
            Tree[index] = Mod(Tree[index * 2], Tree[index * 2 + 1]);
        }
    }

    public static long MulTree(int startIndex, int endIndex) {
        startIndex = (int) (startIndex + (Math.pow(2, k) - 1));
        endIndex = (int) (endIndex + (Math.pow(2, k) - 1));

        long mul = 1;
        while (startIndex <= endIndex) {
            if (startIndex % 2 == 1) {
                mul = Mod(mul, Tree[startIndex]);
            }

            if (endIndex % 2 == 0) {
                mul = Mod(mul, Tree[endIndex]);
            }

            startIndex = (startIndex + 1) / 2;
            endIndex = (endIndex - 1) / 2;
        }

        return mul;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        k = 0;
        while (Math.pow(2, k) < N) {
            k++;
        }

        Tree = new long[(int) Math.pow(2, k + 1)];
        Arrays.fill(Tree, 1);   // 구간 곱이기 때문에 1로 초기화

        int index = (int) Math.pow(2, k);
        for (int i = 0; i < N; i++) {
            Tree[index] = Integer.parseInt(bf.readLine());
            index++;
        }

        for (int i = (int) (Math.pow(2, k) - 1); i > 0; i--) {
            Tree[i] = Mod(Tree[2 * i], Tree[2 * i + 1]);
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                ChangeTree(b, c);
            } else if (a == 2) {
                long answer = MulTree(b, c);
                bw.write(answer + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
