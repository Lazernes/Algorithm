import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static boolean[][] chessBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        chessBoard = new boolean[8][8];
        int answer = 0;
        for (int i = 0; i < 8; i++) {

            String temp = bf.readLine();
            String[] tempArr = temp.split("");

            if (i % 2 == 0) {   // 첫번째 칸이 흰색
                for (int j = 0; j < 8; j = j + 2) {
                    if (tempArr[j].equals("F")) {
                        answer++;
                    }
                }
            } else {    // 첫번째 칸이 검은색
                for (int j = 1; j < 8; j = j + 2) {
                    if (tempArr[j].equals("F")) {
                        answer++;
                    }
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
