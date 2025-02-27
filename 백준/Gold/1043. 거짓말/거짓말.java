import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static ArrayList<ArrayList<Integer>> Graph;

    public static void union(int a, int b) {

        a = find(a);
        b = find(b);

        if (a != b) {   // 0은 진실을 알고 있는 사람
            arr[b] = a;
        }
    }

    public static int find(int a) {

        if (a == arr[a]) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph = new ArrayList<>();
        arr = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = i;
        }

        st = new StringTokenizer(bf.readLine());
        int iter = Integer.parseInt(st.nextToken());

        ArrayList<Integer> trueP = new ArrayList<>();

        for (int i = 0; i < iter; i++) {
            int temp = Integer.parseInt(st.nextToken());
            trueP.add(temp);
        }

        for (int i = 0; i < M; i++) {
            Graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int tempIter = Integer.parseInt(st.nextToken());

            for (int j = 0; j < tempIter; j++) {
                int temp = Integer.parseInt(st.nextToken());
                Graph.get(i).add(temp);
            }

            for (int j = 0; j < tempIter - 1; j++) {
                int temp1 = Graph.get(i).get(j);
                int temp2 = Graph.get(i).get(j + 1);

                union(temp1, temp2);
            }
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            boolean truePerson = true;
            int temp = Graph.get(i).get(0);

            for (int j = 0; j < iter; j++) {

                if (find(temp) == find(trueP.get(j))) {
                    truePerson = false;
                    break;
                }
            }

            if (truePerson) {
                count++;
            }
        }

        System.out.println(count);

    }
}
