import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String st = bf.readLine();
        String[] spSt = st.split("");

        Queue<String> qu = new LinkedList<>();
        String tempInteger = "";
        for (int i = 0; i < spSt.length; i++) {
            if (!spSt[i].equals("+") && !spSt[i].equals("-")) {
                tempInteger += spSt[i];
            } else if (spSt[i].equals("+") || spSt[i].equals("-")) {
                qu.offer(tempInteger);
                qu.offer(spSt[i]);
                tempInteger = "";
            }

            if (i == spSt.length - 1) {
                qu.offer(tempInteger);
            }
        }

        int sum = 0;
        int willAddedInt = 0;
        sum += Integer.parseInt(qu.poll());

        while (!qu.isEmpty()) {
            String temp = qu.poll();

            if (temp.equals("-")) {

                while (!qu.peek().equals("-")) {
                    if (!qu.peek().equals("+")) {
                        willAddedInt += Integer.parseInt(qu.poll());
                        if (qu.isEmpty()) {
                            break;
                        }
                    } else {
                        qu.poll();
                    }

                }
                sum -= willAddedInt;
                willAddedInt = 0;
            } else if (temp.equals("+")) {
                sum += Integer.parseInt(qu.poll());
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
