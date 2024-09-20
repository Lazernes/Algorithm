import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(bf.readLine());
            pq.offer(temp);
        }

        int data1 = 0;
        int data2 = 0;
        int sum = 0;

        while (pq.size() > 1) {
            data1 = pq.poll();
            data2 = pq.poll();
            sum += data1 + data2;
            pq.offer(data1 + data2);
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
