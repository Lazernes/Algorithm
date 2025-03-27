import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;

    public static int[][] Tree;

    public static void PreOrder(int a) throws IOException { // 전위 순회
        if (a == -1) {
            return;
        }

        bw.write(((char) (a + 'A')) + "");
        PreOrder(Tree[a][0]);
        PreOrder(Tree[a][1]);
    }

    public static void InOrder(int a) throws IOException { // 중위 순회
        if (a == -1) {
            return;
        }

        InOrder(Tree[a][0]);
        bw.write(((char) (a + 'A')) + "");
        InOrder(Tree[a][1]);
    }

    public static void PostOrder(int a) throws IOException { // 후위 순회
        if (a == -1) {
            return;
        }

        PostOrder(Tree[a][0]);
        PostOrder(Tree[a][1]);
        bw.write(((char) (a + 'A')) + "");

    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine());
        Tree = new int[N][2];    // 인덱스 0부터 A, 1행은 Right, 2행은 Left

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            char CNode = st.nextToken().charAt(0);
            char LNode = st.nextToken().charAt(0);
            char RNode = st.nextToken().charAt(0);

            int CN = CNode - 'A';
            if (LNode == '.') {
                Tree[CN][0] = -1;
            } else {
                Tree[CN][0] = LNode - 'A';
            }

            if (RNode == '.') {
                Tree[CN][1] = -1;
            } else {
                Tree[CN][1] = RNode - 'A';
            }
        }

        PreOrder(0);
        bw.write("\n" + "");
        InOrder(0);
        bw.write("\n" + "");
        PostOrder(0);

        bw.flush();
        bw.close();
    }
}
