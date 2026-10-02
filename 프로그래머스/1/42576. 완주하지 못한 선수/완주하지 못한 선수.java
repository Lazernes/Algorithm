import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> pMap = new HashMap<>();
        
        for(int i=0; i<participant.length; i++) {
            int temp = pMap.getOrDefault(participant[i], 0);
            pMap.put(participant[i], temp + 1);
        }
        
        // System.out.println(pMap);
        
        for(int i=0; i<completion.length; i++) {
            int temp = pMap.get(completion[i]);
            pMap.put(completion[i], temp - 1);
        }
        
        String answer = "";
        
        Set<String> keySet = pMap.keySet();
        // System.out.println(pMap);
        for(String key:keySet) {
            if(pMap.get(key) == 1) {
                answer = key;
            }
        }
        
        return answer;
    }
}