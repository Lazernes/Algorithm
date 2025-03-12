import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> Tree;
    public static boolean[] Visit;
    public static int count = 0;

    public static void DFS(int a) {

        if (Tree.get(a).size() == 0) {
            count++;
        }

        for (int i = 0; i < Tree.get(a).size(); i++) {
            int nextNode = Tree.get(a).get(i);
            if (!Visit[nextNode]) {
                Visit[nextNode] = true;
                DFS(nextNode);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        Visit = new boolean[N];
        Tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int root = 0;

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent != -1) {
                Tree.get(parent).add(i);
            } else {
                root = i;
            }
        }

        int del = Integer.parseInt(bf.readLine());
        if (del == root) {
            for (int i = 0; i < Tree.get(root).size(); i++) {
                Tree.get(root).remove(i);
            }

            bw.write(0 + "\n");

        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < Tree.get(i).size(); j++) {
                    if (Tree.get(i).get(j) == del) {
                        Tree.get(i).remove(j);
                    }
                }
            }

            DFS(root);

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}
