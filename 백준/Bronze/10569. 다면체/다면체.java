import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int V =  Integer.parseInt(st.nextToken());
            int E =  Integer.parseInt(st.nextToken());

            int answer = 2 - (V - E);
            System.out.println(answer);
        }
    }
}