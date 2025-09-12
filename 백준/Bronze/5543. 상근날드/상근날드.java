import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int minBugger = 2000;
        int minDrink = 2000;

        for (int i = 0; i < 3; i++) {
            int bugger = Integer.parseInt(bf.readLine());
            if (bugger < minBugger) {
                minBugger = bugger;
            }
        }

        for (int i = 0; i < 2; i++) {
            int drink = Integer.parseInt(bf.readLine());
            if (drink < minDrink) {
                minDrink = drink;
            }
        }

        System.out.println(minDrink + minBugger - 50);
    }
}