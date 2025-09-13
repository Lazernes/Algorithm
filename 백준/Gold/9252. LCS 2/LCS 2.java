import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static String A;
    public static String B;

    public static int[][] D;
    public static Stack<Character> LCS = new Stack<>();
    public static int maxLen;

    public static void LCS(int a, int b) {
        if (a == 0 || b == 0) {
            return;
        }

        if (A.charAt(a - 1) == B.charAt(b - 1)) {
            LCS.push(A.charAt(a - 1));
            LCS(a - 1, b - 1);
        } else {
            if (D[a - 1][b] > D[a][b - 1]) {
                LCS(a - 1, b);
            } else {
                LCS(a, b - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        A = bf.readLine();
        B = bf.readLine();

        D = new int[A.length() + 1][B.length() + 1];

        for (int i = 1; i < A.length() + 1; i++) {
            for (int j = 1; j < B.length() + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    D[i][j] = D[i - 1][j - 1] + 1;
                } else {
                    D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
                }
            }
        }

        maxLen = D[A.length()][B.length()];
        System.out.println(maxLen);

        if (maxLen != 0) {
            LCS(A.length(), B.length());
            int iter = LCS.size();
            for (int i = 0; i < iter; i++) {
                System.out.print(LCS.pop());
            }
        }

    }
}
