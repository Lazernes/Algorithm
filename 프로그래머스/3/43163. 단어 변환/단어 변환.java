import java.util.*;

class Solution {
    
    int answer = 0;
    boolean[] visit;
    Queue<String> qu = new LinkedList<>();
    
    public int solution(String begin, String target, String[] words) {
        
        visit = new boolean[words.length];
        qu.offer(begin);
        
        while(!qu.isEmpty()) {
            int size = qu.size();
            
            for(int i=0; i<size; i++) {
                String node = qu.poll();
            
                if(node.equals(target)) {
                    return answer;
                }
            
                for(int j=0; j<words.length; j++) {
                    if(canExchange(node, words[j]) && !visit[j]) {
                        visit[j] = true;
                        qu.add(words[j]);
                    }
                }   
            }
            
            answer++;
        }
        
        return 0;
    }
    
    private boolean canExchange(String node, String word) {
        int count = 0;
        
        for(int i=0; i<node.length(); i++) {
            if(node.charAt(i) == word.charAt(i)) {
                count++;
            }
        }
        
        if(count == node.length() - 1) {
            return true;
        }
        
        return false;
    }


}