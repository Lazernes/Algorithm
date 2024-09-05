import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        String[] notHearName = new String[N];
        ArrayList<String> notHSName = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            notHearName[i] = sc.next();
        }

        Arrays.sort(notHearName);

        for (int i = 0; i < M; i++) {
            String notSeeName = sc.next();
            if (Arrays.binarySearch(notHearName, notSeeName) >= 0) {
                notHSName.add(notSeeName);
            }
        }

        int iter = notHSName.size();
        System.out.println(iter);

        Collections.sort(notHSName);
        for (int i = 0; i < iter; i++) {
            System.out.println(notHSName.get(i));
        }


    }
}
