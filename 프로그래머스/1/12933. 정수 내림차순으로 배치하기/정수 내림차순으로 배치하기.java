import java.util.*;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int iter = s.length();
        
        for(int i=0; i<iter; i++) {
            char temp = s.charAt(i);
            Integer digit = temp - '0';
            pq.add(digit);
        }
                
        long answer = 0;
        answer+=pq.poll();
        
        while(!pq.isEmpty()) {
            answer*=10;
            answer+=pq.poll();
        }
        
        return answer;
    }
}