import java.io.*;
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

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());

            int k = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (k == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }

    }


}
