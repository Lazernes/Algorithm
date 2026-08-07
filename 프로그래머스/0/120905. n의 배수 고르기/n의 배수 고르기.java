import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<numlist.length; i++) {
            
            int a = numlist[i];
            
            if(a%n==0) {
                list.add(a);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).intValue();
       }
        
        return answer;
    }
}