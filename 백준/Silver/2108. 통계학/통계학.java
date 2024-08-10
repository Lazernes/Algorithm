import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[];
        arr = new int[N];
        int num[];
        num = new int[8001]; // 0(-4000) ~ 4000(0) ~ 8000(4000)
        int maxiter = 0; // 최대 빈도수를 찾기 위한 변수
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            num[arr[i] + 4000]++;

            if (maxiter < num[arr[i] + 4000]) {
                maxiter = num[arr[i] + 4000];
            }

        }

        Arrays.sort(arr);

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + arr[i];
        }

        String mean = String.format("%.0f", sum / N);
        if (mean.equals("-0")) {
            mean = "0";
        }
        System.out.println(mean);   // 산술평균

        int mid = arr[N / 2];
        System.out.println(mid);    // 중앙값

        boolean tmp = false;
        int maxiternum = 0;
        for (int i = 0; i <= 8000; i++) {

            // 첫번째 최빈값을 찾으면 그것을 저장
            if (!tmp && num[i] == maxiter) {
                tmp = true;
                maxiternum = i - 4000;
                continue;
            }

            // 만약 최빈값이 같은 수가 있으면 2번째 작은 수 출력
            if (tmp && num[i] == maxiter) {
                maxiternum = i - 4000;
                break;
            }
        }

        System.out.println(maxiternum);

        int scope = arr[N - 1] - arr[0];
        System.out.println(scope);  // 범위

    }
}
