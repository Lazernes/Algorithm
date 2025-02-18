import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> Tree;

    public static boolean Visit[];
    public static int parent[];

    public static void DFS(int a) {
        if (Visit[a]) {
            return;
        }

        Visit[a] = true;
        for (int i = 0; i < Tree.get(a).size(); i++) {
            int next = Tree.get(a).get(i);

            if (!Visit[next]) {
                parent[next] = a;
                DFS(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Tree = new ArrayList<>();

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i <= N; i++) {
            Tree.add(new ArrayList<>());
        }

        Visit = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Tree.get(a).add(b);
            Tree.get(b).add(a);
        }

        DFS(1);

        for (int i = 2; i < N + 1; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
