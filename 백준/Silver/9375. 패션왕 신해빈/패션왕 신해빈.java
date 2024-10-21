import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void Shin() throws IOException {
        int n = Integer.parseInt(bf.readLine());
        List<String> clothes = new ArrayList<>();   // 옷의 종류를 저장
        List<Integer> count = new ArrayList<>();    // 종류에 대한 옷의 갯수를 저장

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            String type = st.nextToken();

            if (clothes.contains(type)) {
                int temp = count.get(clothes.indexOf(type));
                temp++;
                count.set(clothes.indexOf(type), temp);
            } else {
                clothes.add(type);
                count.add(1);
            }
        }
        
        int result = 0;
        for (int i = 0; i < clothes.size(); i++) {
            result = result + count.get(i) * (1 + result);
        }

        bw.write(result + "\n");
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            Shin();
        }

        bw.flush();
        bw.close();
    }
}
