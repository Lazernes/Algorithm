import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            String name = bf.readLine();
            for (int j = 0; j < name.length(); j++) {
                char temp = name.charAt(j);
                if ('A' <= temp && temp <= 'Z') {
                    temp = (char) (temp + 32);
                }

                System.out.print(temp);
            }
            System.out.println();
        }
    }
}
