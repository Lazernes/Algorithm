import java.util.Scanner;

public class Main {

    static char[][] WordArr;

    public static char[][] getSample(int a, int b) {
        char[][] temp = new char[8][8];
        for (int n = 0; n < 8; n++) {
            for (int m = 0; m < 8; m++) {
                temp[n][m] = WordArr[a + n][b + m];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        char[][] Black = {
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'}
        };

        char[][] White = {
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'}
        };


        WordArr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = scanner.next();
            for (int j = 0; j < M; j++) {
                WordArr[i][j] = s.charAt(j);
            }
        }

        int result = 64;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                char[][] Sample = getSample(i, j);

                int count = 0;

                int count_B = 0;

                for(int temp_i=0;temp_i<8;temp_i++){
                    for(int temp_j=0;temp_j<8;temp_j++){
                        if(Sample[temp_i][temp_j] != Black[temp_i][temp_j]){
                            count_B++;
                        }
                    }
                }

                int count_W = 0;

                for(int temp_i=0;temp_i<8;temp_i++){
                    for(int temp_j=0;temp_j<8;temp_j++){
                        if(Sample[temp_i][temp_j] != White[temp_i][temp_j]){
                            count_W++;
                        }
                    }
                }

                if(count_W<count_B){
                    count = count_W;
                }
                else{
                    count = count_B;
                }

                if(count < result)
                    result = count;
            }
        }

        System.out.print(result);
    }
}
