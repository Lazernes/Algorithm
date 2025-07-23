import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(bf.readLine());
        int A = Integer.parseInt(bf.readLine());
        int B = Integer.parseInt(bf.readLine());
        int C = Integer.parseInt(bf.readLine());
        int D = Integer.parseInt(bf.readLine());

        int korean = 0;
        int math = 0;

        if (A % C != 0) {
            korean = A / C + 1;
        } else {
            korean = A / C;
        }

        if (B % D != 0) {
            math = B / D + 1;
        } else {
            math = B / D;
        }

        int study = korean > math ? korean : math;
        System.out.println(L - study);
    }
}
