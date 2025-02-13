import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(bf.readLine());
        int B = Integer.parseInt(bf.readLine());

        System.out.println(A + B);
    }

}
