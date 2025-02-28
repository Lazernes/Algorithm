import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> Graph;
    public static int[] Students;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> qu = new LinkedList<>();

        Students = new int[N + 1];
        Graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            Graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Graph.get(A).add(B);
            Students[B]++;
        }

        for (int i = 1; i < N + 1; i++) {
            if (Students[i] == 0) {
                qu.add(i);
            }
        }

        while (!qu.isEmpty()) {
            int std = qu.poll();

            bw.write(std + " ");

            for (int i = 0; i < Graph.get(std).size(); i++) {
                int temp = Graph.get(std).get(i);

                Students[temp]--;
                if (Students[temp] == 0) {
                    qu.add(temp);
                }
            }
        }

        bw.flush();
        bw.close();

    }
}
