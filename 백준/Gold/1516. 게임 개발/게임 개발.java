import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        ArrayList<ArrayList<Integer>> Building = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            Building.add(new ArrayList<>());
        }

        int[] D = new int[N + 1];
        int[] Time = new int[N + 1];
        int[] Result = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            Time[i] = a;

            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }

                Building.get(next).add(i);
                D[i]++;
            }
        }

        Queue<Integer> qu = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            if (D[i] == 0) {
                qu.add(i);
            }
        }

        while (!qu.isEmpty()) {
            int next = qu.poll();

            for (int i = 0; i < Building.get(next).size(); i++) {
                int temp = Building.get(next).get(i);

                D[temp]--;
                Result[temp] = Math.max(Result[temp], Result[next] + Time[next]);
                if (D[temp] == 0) {
                    qu.add(temp);
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            Result[i] = Result[i] + Time[i];
            bw.write(Result[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
