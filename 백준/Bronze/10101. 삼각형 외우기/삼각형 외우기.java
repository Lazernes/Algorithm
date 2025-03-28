import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());

        if (a == 60 && b == 60 && c == 60) {
            System.out.println("Equilateral");
        } else if (a + b + c == 180 && (a == b || b == c || c == a)) {
            System.out.println("Isosceles");
        } else if (a + b + c == 180) {
            System.out.println("Scalene");
        } else {
            System.out.println("Error");
        }
    }
}
