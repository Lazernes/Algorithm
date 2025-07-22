import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String ah1 = bf.readLine();
        String ah2 = bf.readLine();

        if (ah1.length() >= ah2.length()) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }

    }
}
