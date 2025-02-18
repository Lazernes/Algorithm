import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int A, B, C;
    public static boolean Visit[][];

    public static boolean result[];

    public static void DFS(int a, int b) {

        if (Visit[a][b]) {
            return;
        }

        Visit[a][b] = true;

        int c = C - (a + b);    // 물통 C에 있는 물의 양
        if (a == 0) {
            result[c] = true;
        }

        if (a > 0) {
            if (a + b > B) {    // A to B
                DFS(a + b - B, B);
            } else {
                DFS(0, a + b);
            }

            DFS(0, b);  // A to C
        }

        if (b > 0) {
            if (a + b > A) {
                DFS(A, a + b - A);
            } else {
                DFS(a + b, 0);
            }

            DFS(a, 0);
        }

        if (c > 0) {
            if (a + c > A) {
                DFS(A, b);
            } else {
                DFS(a + c, b);
            }

            if (b + c > B) {
                DFS(a, B);
            } else {
                DFS(a, b + c);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Visit = new boolean[A + 1][B + 1];
        result = new boolean[C + 1];

        DFS(0, 0);

        for (int i = 0; i < C + 1; i++) {
            if (result[i]) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }


}
