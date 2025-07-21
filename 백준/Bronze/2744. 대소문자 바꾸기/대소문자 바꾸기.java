import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);

            if (temp >= 97) {
                temp -= 32;
            } else {
                temp += 32;
            }

            System.out.print(temp);
        }
    }
}
