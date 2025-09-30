import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int D = Integer.parseInt(bf.readLine());

        A += D / 3600;
        D %= 3600;

        B += D / 60;
        D %= 60;

        C += D;

        if (C >= 60) {
            B++;
            C -= 60;
        }

        if (B >= 60) {
            A++;
            B -= 60;
        }

        while (A >= 24) {
            A -= 24;
        }

        System.out.println(A + " " + B + " " + C);
    }
}
