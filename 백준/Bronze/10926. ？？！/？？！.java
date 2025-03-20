import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String Id = bf.readLine();
        bw.write(Id + "??!");
        bw.flush();
        bw.close();
    }
}
