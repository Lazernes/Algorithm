import java.util.*;

class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String tree : skill_trees) {
            int index = 0;
            boolean canLearn = true;
            
            for(char c : tree.toCharArray()) {
                
                if(skill.indexOf(c) == -1) {
                    continue;
                }
                
                if(c == skill.charAt(index)) {
                    index++;
                } else {
                    canLearn = false;
                    break;
                }
            }
            
            if(canLearn) {
                answer++;
            }
        }
        
        return answer;
    }
}