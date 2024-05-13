import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static boolean VPS(String S) {
        Stack<Character> PS = new Stack<>();

        if (S.charAt(0) != '(') {
            return false;
        }

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                PS.push(S.charAt(i));
            } else {
                if (!PS.isEmpty() && PS.peek() == '(') {
                    PS.pop();
                } else {
                    return false;
                }
            }
        }

        if (!PS.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            String S = scanner.next();
            if (VPS(S)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
