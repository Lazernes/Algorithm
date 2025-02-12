import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int P = Integer.parseInt(bf.readLine());

        for (int i = 0; i < P; i++) {
            String s = bf.readLine();
            String[] arr = s.split("");
            int[] result = new int[8];

            for (int j = 0; j < 38; j++) {
                String temp = arr[j] + arr[j + 1] + arr[j + 2];

                if (temp.equals("TTT")) {
                    result[0]++;
                } else if (temp.equals("TTH")) {
                    result[1]++;
                } else if (temp.equals("THT")) {
                    result[2]++;
                } else if (temp.equals("THH")) {
                    result[3]++;
                }else if (temp.equals("HTT")) {
                    result[4]++;
                }else if (temp.equals("HTH")) {
                    result[5]++;
                }else if (temp.equals("HHT")) {
                    result[6]++;
                }else if (temp.equals("HHH")) {
                    result[7]++;
                }
            }

            for (int k = 0; k < 8; k++) {
                bw.write(result[k] + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
