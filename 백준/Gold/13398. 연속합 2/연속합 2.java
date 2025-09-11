import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] L = new int[N];
        int[] R = new int[N];

        L[0] = A[0];
        int max = A[0];

        for (int i = 1; i < N; i++) {
            L[i] = Math.max(L[i - 1] + A[i], A[i]);
            // 하나도 제거하지 않았을 때를 기본 최대값으로 저장
            max = Math.max(max, L[i]);
        }

        R[N - 1] = A[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            R[i] = Math.max(A[i], R[i + 1] + A[i]);
        }

        // L[i - 1] + R[i + 1] 두 개의 구간 합 배열을 더해주면 i 번째 값을 제거한 효과
        for (int i = 1; i < N - 1; i++) {
            int temp = L[i - 1] + R[i + 1];
            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}
