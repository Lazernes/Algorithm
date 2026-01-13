import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int answer = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A  = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (A < N) {
            answer += A;
        } else {
            answer += N;
        }

        if (B < N) {
            answer += B;
        } else {
            answer += N;
        }

        if (C < N) {
            answer += C;
        } else {
            answer += N;
        }

        System.out.println(answer);
    }
}