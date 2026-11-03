import java.util.*;

class Solution {
    public String solution(String my_string) {
        String lower = my_string.toLowerCase();
        char[] arr = lower.toCharArray();
        Arrays.sort(arr);
        
        String answer = "";
        for(int i=0; i<arr.length; i++) {
            answer += arr[i];
        }
        
        return answer;
    }
}