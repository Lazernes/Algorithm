import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int startHH = Integer.parseInt(st.nextToken());
        int startMM = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int endHH = Integer.parseInt(st.nextToken());
        int endMM = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(bf.readLine());
        int count = 0;

        while (true) {
            if ((startHH % 10 == N || startHH / 10 == N) || (startMM % 10 == N || startMM / 10 == N)) {
                count++;
            }

            if ((startHH == endHH) && (startMM == endMM)) {
                break;
            }

            startMM++;
            if (startMM >= 60) {
                startHH++;
                startMM = 0;
            }
        }

        System.out.println(count);
    }
}
