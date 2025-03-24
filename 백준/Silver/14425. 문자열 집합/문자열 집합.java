import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        root = new Node();

        while (N > 0) {
            String text = bf.readLine();
            Node now = root;

            for (int i = 0; i < text.length(); i++) {
                char a = text.charAt(i);

                // 입력은 소문자로만 이루어져 있고 index를 나타내기 위해 'a'를 뺌
                if (now.next[a - 'a'] == null) {
                    now.next[a - 'a'] = new Node();
                }
                now = now.next[a - 'a'];
                if (i == text.length() - 1) {
                    now.isEnd = true;
                }
            }

            N--;
        }

        int count = 0;
        while (M > 0) {
            String text = bf.readLine();
            Node now = root;
            for (int i = 0; i < text.length(); i++) {
                char a = text.charAt(i);
                if (now.next[a - 'a'] == null) {
                    break;
                }   // now의 next가 존재하지 않으면 break

                now = now.next[a - 'a'];
                if (i == text.length() - 1 && now.isEnd) {
                    count++;
                }
            }
            M--;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }

    public static class Node {
        Node[] next = new Node[26];    // 알파벳 26개
        boolean isEnd;  // 문자열의 마지막인지 표시
    }
}
