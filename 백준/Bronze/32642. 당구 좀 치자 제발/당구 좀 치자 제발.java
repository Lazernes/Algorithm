import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long sum = 0;
        long angry = 0;

        for(int i=0;i<N;i++) {
            int temp = Integer.parseInt(st.nextToken());

            if(temp == 0) {
                angry--;
            } else{
                angry++;
            } 
            sum += angry;
        }

        System.out.println(sum);
    }
}