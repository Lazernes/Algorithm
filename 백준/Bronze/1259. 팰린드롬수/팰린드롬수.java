import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            char [] arr;
            arr = new char[5];

            String temp = scanner.next();

            char[] tempchar = temp.toCharArray();

            if(tempchar[0] == '0'){
                break;
            }

            for (int i = 0; i < temp.length(); i++) {
                arr[i] = tempchar[i];
            }

            int low, high;
            low = 0;
            high = temp.length() - 1;

            boolean result = false;
            
            if(temp.length()==1){
                result = true;
            }
            else{
                while (low < high) {
                if (arr[low] == arr[high]) {
                    result = true;
                }
                else{
                    result = false;
                    break;
                }
                low++;
                high--;
              }
            }

            if (result) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }
}
