import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if(s < n) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[n];
        Arrays.fill(answer, s/n);
        
        s %=n;
        
        for(int i=n - 1; i>0;i--) {
            if(s == 0) {
                break;
            }
            
            answer[i]++;
            s--;
        }
        
        return answer;
    }
}