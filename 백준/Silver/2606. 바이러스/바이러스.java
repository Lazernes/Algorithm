import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] graph;
    public static boolean[] check;

    public static void visit(int a) {
        for (int i = 1; i <= N; i++) {
            if (!check[i] && graph[a][i] == 1) {
                check[i] = true;
                visit(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bf.readLine());
        graph = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        int iter = Integer.parseInt(bf.readLine());
        for (int i = 0; i < iter; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visit(1);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (check[i]) {
                count++;
            }
        }

        if (count == 0) {   // 1과 연결된 컴퓨터가 없을 경우
            count++;
        }
        
        bw.write((count - 1) + "\n");
        bw.flush();
        bw.close();
    }
}
