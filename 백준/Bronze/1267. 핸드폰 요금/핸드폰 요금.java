import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int Y(int time) {
        int iter = time / 30;
        iter++;

        return iter * 10;
    }

    public static int M(int time) {
        int iter = time / 60;
        iter++;

        return iter * 15;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int YCost = 0;
        int MCost = 0;

        for (int i = 0; i < N; i++) {
            int Time = Integer.parseInt(st.nextToken());

            YCost += Y(Time);
            MCost += M(Time);
        }

        if (YCost > MCost) {
            System.out.println("M " + MCost);
        } else if (MCost > YCost) {
            System.out.println("Y " + YCost);
        } else {
            System.out.println("Y M " + MCost);
        }

        bw.flush();
        bw.close();
    }
}
