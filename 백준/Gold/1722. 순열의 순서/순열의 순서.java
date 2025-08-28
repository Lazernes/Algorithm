import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int Q = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[21];
        long[] F = new long[21];
        int[] S = new int[21];

        F[0] = 1;   // 0! = 1

        for (int i = 1; i < N + 1; i++) {
            F[i] = F[i - 1] * i;
        }

        if (Q == 1) {
            long k = Long.parseLong(st.nextToken());

            for (int i = 1; i < N + 1; i++) {
                int count = 1;

                for (int j = 1; j < N + 1; j++) {

                    if (visited[j]) {
                        continue;
                    }

                    if (k <= count * F[N - i]) {
                        k = k - (F[N - i] * (count - 1));
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                    count++;
                }
            }

            for (int i = 1; i < N + 1; i++) {
                System.out.print(S[i] + " ");
            }
        } else {
            long k = 1;
            for (int i = 1; i <= N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                long count = 0;
                for (int j = 1; j < S[i]; j++) {
                    if (!visited[j]) {
                        count++;
                    }
                }

                k = k + F[N - i] * count;
                visited[S[i]] = true;
            }

            System.out.println(k);
        }
    }
}
