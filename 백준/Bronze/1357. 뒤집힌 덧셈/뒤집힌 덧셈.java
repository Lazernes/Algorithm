import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        String[] temp1 = new String[4];
        String[] temp2 = new String[4];

        temp1 = st.nextToken().split("");
        temp2 = st.nextToken().split("");

        Queue<Integer> qu1 = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();

        int a = temp1.length;
        int b = temp2.length;

        int X = 0;
        int Y = 0;

        for (int i = 0; i < a; i++) {
            qu1.add(Integer.parseInt(temp1[i]));
        }

        for (int i = 0; i < b; i++) {
            qu2.add(Integer.parseInt(temp2[i]));
        }

        for (int i = 0; i < a; i++) {
            X += qu1.peek() * Math.pow(10, i);
            qu1.poll();
        }

        for (int i = 0; i < b; i++) {
            Y += qu2.peek() * Math.pow(10, i);
            qu2.poll();
        }

        int tempResult = X + Y;

        int result = 0;

        while (tempResult > 0) {
            int reminder = tempResult % 10;
            result = (result * 10) + reminder;
            tempResult /= 10;
        }

        System.out.println(result);

    }



}
