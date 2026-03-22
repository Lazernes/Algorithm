import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int year = 2024;
        int month = 8;
        month += (N - 1) * 7;
        year += month / 12;
        month %= 12;

        if(month == 0){
            year--;
            month = 12;
        }

        System.out.println(year + " " + month);
    }
}