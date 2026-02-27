import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int bYear =  Integer.parseInt(st.nextToken());
        int bMonth = Integer.parseInt(st.nextToken());
        int bDay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int cYear = Integer.parseInt(st.nextToken());
        int cMonth = Integer.parseInt(st.nextToken());
        int cDay = Integer.parseInt(st.nextToken());

        int age = cYear - bYear;

        if (cMonth < bMonth) {
            System.out.println(age - 1);
        } else if (cMonth == bMonth && cDay < bDay) {
            System.out.println(age - 1);
        }
        else {
            System.out.println(age);
        }

        System.out.println(age + 1);
        System.out.println(age);

    }
}