import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static boolean isInteger(String st) {
        try {
            Integer.parseInt(st);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }   // String이 Integer인지 확인하는 함수

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> Dic = new HashMap<Integer, String>();
        HashMap<String, Integer> tmpDic = new HashMap<String, Integer>();
        for (int i = 1; i <= N; i++) {
            String a = bf.readLine();
            Dic.put(i, a);
            tmpDic.put(a, i);
        }

        for (int i = 0; i < M; i++) {
            String tmp = bf.readLine();
            if (isInteger(tmp)) {
                bw.write(Dic.get(Integer.parseInt(tmp)) + "\n");
            } else {
                bw.write(tmpDic.get(tmp) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

}
