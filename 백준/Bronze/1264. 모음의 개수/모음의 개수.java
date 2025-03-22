import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while (true) {
            input = bf.readLine();
            if (input.equals("#")) {
                break;
            }
            String[] temp = input.split("");
            int count = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i].equals("a") || temp[i].equals("e") || temp[i].equals("i") || temp[i].equals("o") || temp[i].equals("u") ||
                    temp[i].equals("A") || temp[i].equals("E") || temp[i].equals("I") || temp[i].equals("O") || temp[i].equals("U")){
                    count++;
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}
