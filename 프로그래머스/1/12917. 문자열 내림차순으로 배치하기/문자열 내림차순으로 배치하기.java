import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        Character[] a = new Character[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            Character temp = s.charAt(i);
            a[i] = temp;
        }
        
        Arrays.sort(a, Collections.reverseOrder());
        
        for(int i=0; i<s.length(); i++) {
            answer += String.valueOf(a[i]);
        }
        
        
        return answer;
    }
}