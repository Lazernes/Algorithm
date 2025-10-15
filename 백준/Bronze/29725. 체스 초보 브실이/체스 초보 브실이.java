import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int white = 0;
        int black = 0;

        for (int i = 0; i < 8; i++) {
            String input = bf.readLine();

            for (int j = 0; j < 8; j++) {
                char chess = input.charAt(j);

                if ('a' <= chess && chess <= 'z') {
                    // black
                    if (chess == 'k') {
                        black += 0;
                    } else if (chess == 'p') {
                        black += 1;
                    } else if (chess == 'n') {
                        black += 3;
                    } else if (chess == 'b') {
                        black += 3;
                    } else if (chess == 'r') {
                        black += 5;
                    } else if (chess == 'q') {
                        black += 9;
                    }

                } else if ('A' <= chess && chess <= 'Z') {
                    // white
                    if (chess == 'K') {
                        white += 0;
                    } else if (chess == 'P') {
                        white += 1;
                    } else if (chess == 'N') {
                        white += 3;
                    } else if (chess == 'B') {
                        white += 3;
                    } else if (chess == 'R') {
                        white += 5;
                    } else if (chess == 'Q') {
                        white += 9;
                    }
                }
            }
        }

        System.out.println(white - black);
    }
}
