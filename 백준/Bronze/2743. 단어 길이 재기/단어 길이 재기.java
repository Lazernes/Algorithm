import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bf.readLine();
        
        bw.write(input.length() + "\n");
        bw.flush();
        bw.close();
    }
}
