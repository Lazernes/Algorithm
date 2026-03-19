import java.util.*;

class Solution {
    public String solution(String s, int n) {
        
        String answer = "";
        char[] arr = s.toCharArray();
        
        for(int i=0; i<arr.length; i++) {
            
            if(arr[i] == ' ') {
                answer += String.valueOf(arr[i]);
                continue;
            }
            
            if('A' <= arr[i] && arr[i] <='Z') {
                int temp = arr[i] - 'A';
                temp += n;
                
                arr[i] = (char) ('A' + temp % 26);
            } else {
                int temp = arr[i] - 'a';
                temp += n;
                
                arr[i] = (char) ('a' + temp % 26);
            }
            
            answer += String.valueOf(arr[i]);
        }
        
        return answer;
    }
}