import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static ArrayList<ArrayList<Integer>> Graph;
    public static int[] Visit;
    public static boolean IsBiGraph;

    public static int V;
    public static int E;

    public static void DFS(int a) {
        for (int i = 0; i < Graph.get(a).size(); i++) {
            int temp = Graph.get(a).get(i);

            if (Visit[temp] == 0) {
                if (Visit[a] == 2) {
                    Visit[temp] = 3;
                    DFS(temp);
                } else {
                    Visit[temp] = 2;
                    DFS(temp);
                }
            } else if (Visit[temp] == Visit[a]) {
                IsBiGraph = false;
            }
        }
    }

    public static void BiGraph() throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Graph = new ArrayList<>();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        IsBiGraph = true;

        for (int i = 0; i <= V; i++) {
            Graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Graph.get(a).add(b);
            Graph.get(b).add(a);
        }

        Visit = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            if (Visit[i] == 0) {
                Visit[i] = 2;
                DFS(i);
                if (!IsBiGraph) {
                    break;
                }
            }
        }

        if (IsBiGraph) {
            bw.write("YES\n");
        } else {
            bw.write("NO\n");
        }

    }

    public static void main(String[] args) throws IOException {

        int K = Integer.parseInt(bf.readLine());
        for (int i = 0; i < K; i++) {
            BiGraph();
        }

        bw.flush();
        bw.close();
    }
}
