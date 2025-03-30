import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[] Tree;
    public static int k;

    public static int Min(int startIndex, int endIndex) {
        startIndex = (int) (startIndex + (Math.pow(2, k) - 1));
        endIndex = (int) (endIndex + (Math.pow(2, k) - 1));

        int min = 1000000000;
        while (startIndex <= endIndex) {
            if (startIndex % 2 == 1) {
                if (Tree[startIndex] < min) {
                    min = Tree[startIndex];
                }
            }

            if (endIndex % 2 == 0) {
                if (Tree[endIndex] < min) {
                    min = Tree[endIndex];
                }
            }

            startIndex = (startIndex + 1) / 2;
            endIndex = (endIndex - 1) / 2;
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        k = 0;
        while (Math.pow(2, k) < N) {
            k++;
        }

        Tree = new int[(int) Math.pow(2, k + 1)];

        int index = (int) Math.pow(2, k);
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(bf.readLine());
            Tree[index] = input;
            index++;
        }

        for (int i = (int) (Math.pow(2, k) - 1); i > 0; i--) {
            Tree[i] = Math.min(Tree[2 * i], Tree[2 * i + 1]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = Min(a, b);
            bw.write(min + "\n");
        }

        bw.flush();
        bw.close();
    }
}
