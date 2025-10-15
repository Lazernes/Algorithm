import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("n e");
        System.out.println("- -----------");
        System.out.println("0 1");
        System.out.println("1 2");
        System.out.println("2 2.5");

        double factorial = 2;
        double i = 2;
        double result = 2.5;

        while (factorial < 9) {
            factorial++;
            i *= factorial;
            result += 1 / i;
            System.out.printf("%.0f %.9f\n", factorial, result);
        }

    }
}
