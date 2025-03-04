import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        int[] D = new int[n + 1];
        int[] Time = new int[n + 1];

        ArrayList<ArrayList<Node>> TMap = new ArrayList<>();
        ArrayList<ArrayList<Node>> ReTMap = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            TMap.add(new ArrayList<>());
            ReTMap.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            TMap.get(start).add(new Node(end, time));
            ReTMap.get(end).add(new Node(start, time));
            D[end]++;
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> qu = new LinkedList<>();
        qu.add(start);

        while (!qu.isEmpty()) {
            int now = qu.poll();

            for (int i = 0; i < TMap.get(now).size(); i++) {
                Node next = TMap.get(now).get(i);

                D[next.destination]--;
                Time[next.destination] = Math.max(Time[next.destination], Time[now] + next.time);
                if (D[next.destination] == 0) {
                    qu.add(next.destination);
                }
            }
        }

        qu.add(end);
        int count = 0;
        boolean[] Visit = new boolean[n + 1];
        Visit[end] = true;

        while (!qu.isEmpty()) {
            int now = qu.poll();

            for (int i = 0; i < ReTMap.get(now).size(); i++) {
                Node next = ReTMap.get(now).get(i);
                if (Time[next.destination] + next.time == Time[now]) {
                    count++;

                    if (Visit[next.destination] == false) {
                        Visit[next.destination] = true;
                        qu.add(next.destination);
                    }
                }
            }
        }

        bw.write(Time[end] + "\n");
        bw.write(count + "");
        bw.flush();
        bw.close();
    }

    public static class Node {
        int destination;
        int time;

        public Node(int destination, int time) {
            this.destination = destination;
            this.time = time;
        }
    }
}
