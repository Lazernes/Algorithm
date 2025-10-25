import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] st = s.split(" ");
        int size = st.length;
        int[] arr = new int[size];
        for(int i=0;i<size;i++) {
            arr[i] = Integer.parseInt(st[i]);
        }
        
        Arrays.sort(arr);
        answer = arr[0] + " " + arr[size - 1];
        
        return answer;
    }
}