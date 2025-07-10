import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int king = Integer.parseInt(st.nextToken());
        king = 1 - king;

        int queen = Integer.parseInt(st.nextToken());
        queen = 1 - queen;

        int rock = Integer.parseInt(st.nextToken());
        rock = 2 - rock;

        int bishop = Integer.parseInt(st.nextToken());
        bishop = 2 - bishop;

        int knight = Integer.parseInt(st.nextToken());
        knight = 2 - knight;

        int pwan = Integer.parseInt(st.nextToken());
        pwan = 8 - pwan;

        System.out.println(king + " " + queen + " " + rock + " " + bishop + " " + knight + " " + pwan);
    }
}
