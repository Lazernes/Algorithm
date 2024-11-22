import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<ArrayList<Integer>> company = new ArrayList<>();

    public static int[] count;
    public static boolean[] visit;

    public static void BFS(int a) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(a);
        visit[a] = true;

        while (!qu.isEmpty()) {
            int temp = qu.poll();

            for (int i : company.get(temp)) {
                if (!visit[i]) {
                    visit[i] = true;
                    count[a]++;
                    qu.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        count = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            company.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            company.get(B).add(A);
        }

        int maxCount = 0;

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            BFS(i);

            if (count[i] > maxCount) {
                maxCount = count[i];
            }
        }

        // count 배열에서 최대값
        for (int i = 1; i <= N; i++) {
            if (count[i] == maxCount) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}
