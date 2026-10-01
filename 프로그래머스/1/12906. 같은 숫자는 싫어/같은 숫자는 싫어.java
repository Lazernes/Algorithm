import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        
        Deque<Integer> dq = new LinkedList<>();
        dq.offer(arr[0]);
        
        for(int i=1; i<arr.length; i++) {
            if(dq.peekLast() == arr[i]) {
                continue;
            } else {
                dq.offer(arr[i]);
            }
        }
        
        answer = new int[dq.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = dq.poll();
        }
        
        return answer;
    }
}