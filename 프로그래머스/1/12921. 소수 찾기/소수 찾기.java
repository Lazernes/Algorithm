import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] numbers = new boolean[n+1];
        
        Arrays.fill(numbers, true);
        
        numbers[0] = false;
        numbers[1] = false;
        
        for(int i=2; i<=Math.sqrt(n) ; i++) {
            if(numbers[i]) {
                for(int j=i*2; j<n+1; j+=i) {
                    numbers[j] = false;
                }
            }
        }
        
        for(int i=0; i<n+1; i++) {
            if(numbers[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}