import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            String tmp = bf.readLine();
            bw.write(map.get(tmp) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
