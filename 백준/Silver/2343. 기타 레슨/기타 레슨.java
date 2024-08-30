import java.rmi.dgc.VMID;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // Binary Search를 하기 위한 파라미터
        int min = 0;
        int max = 0;

        int[] arr =new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            max = max + arr[i];
            if (arr[i] > min) {
                min = arr[i];
            }
        }

        while (min <= max) {
            int count = 0;
            int mid = (min + max) / 2;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] <= mid) {
                    sum += arr[i];
                }   // sum + arr[i]가 mid값을 넘지 않으면 더하기
                else {
                    count++;
                    sum = arr[i];
                }
            }

            if (sum != 0) {
                count++;
            }

            if (count > M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(min);
    }
}
