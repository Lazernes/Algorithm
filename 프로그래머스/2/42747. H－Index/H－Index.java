import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int hIndex = 0;
        
        for(int i=0; i<10000;i++) {
            int under = 0;
            int upper = 0;
            
            for(int j=0; j<citations.length; j++) {
                if(citations[j] >= i) {
                    upper++;
                } else {
                    under++;
                }
                
                if(upper >=i && under <= i) {
                    hIndex = Math.max(hIndex, i);
                }
            }
            
        }
        
        return hIndex;
    }
}