import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = -1;
        
        long index = 1;
        while(index <= Math.sqrt(n)) {
            
            if(index * index == n) {
                answer = (index + 1) * (index + 1);
                break;
            }
            
            index++;
        }
        
        
        return answer;
    }
}