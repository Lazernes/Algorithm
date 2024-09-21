import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(bf.readLine());
            if (temp > 0) {
                pos.add(temp);
            } else {
                neg.add(temp);
            }
        }

        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg);

        // 양수 배열 계산
        long posSum = 0;
        boolean pS = false;
        int pData = 0;

        if (!pos.isEmpty()) {

            int brInx = 0;  // 1이 나오면 멈추기 위해
            boolean br = false;

            for (int i = 0; i < pos.size(); i++) {

                if (pos.get(i) == 1) {

                    if (pS) {
                        posSum += pData;
                    }

                    brInx = i;
                    br = true;
                    break;
                }

                if (pS == false) {
                    pData = pos.get(i);
                    pS = true;
                } else if (pS) {
                    posSum += pData * pos.get(i);
                    pS = false;
                }

                if (pS && i == pos.size() - 1) {
                    posSum += pData;
                }

            }

            if (br) {
                posSum += (pos.size() - brInx);
            }   // 1은 더해주어야 하므로 1이 존재하면 해당 연산
        }
        // 음수 배열 계산
        long negSum = 0;
        boolean nS = false;
        int nData = 0;

        if (!neg.isEmpty()) {

            for (int i = 0; i < neg.size(); i++) {
                if (nS == false) {
                    nData = neg.get(i);
                    nS = true;
                } else if (nS) {
                    negSum += nData * neg.get(i);
                    nS = false;
                }

                if (nS && i == neg.size() - 1) {
                    negSum += nData;
                }
            }
        }

        long sum = posSum + negSum;
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
