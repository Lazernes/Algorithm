import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int number = 1;
        boolean isGo = false;

        while (number <= N) {
            System.out.print(number + " ");
            isGo = false;

            if (number % 6 == 0) {
                System.out.print("Go!" + " ");
                isGo = true;
            }

            number++;
        }

        if (!isGo) {
            System.out.print("Go!");
        }

    }
}
