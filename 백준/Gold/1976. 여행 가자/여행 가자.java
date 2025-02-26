import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;

    public static void union(int a, int b) {

        a = find(a);
        b = find(b);

        if (a != b) {
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

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = i;
        }

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 1; j < N + 1; j++) {
                int a = Integer.parseInt(st.nextToken());

                if (a == 1) {
                    union(i, j);
                }

            }
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int connect = find(Integer.parseInt(st.nextToken()));
        boolean result = true;

        for (int i = 1; i < M; i++) {
            if (connect != find(Integer.parseInt(st.nextToken()))) {
                result = false;
            }
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
