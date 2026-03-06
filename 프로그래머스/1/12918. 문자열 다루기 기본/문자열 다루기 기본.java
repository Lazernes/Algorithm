class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length() != 4 && s.length() != 6) {
            answer = false;
            return answer;
        }
        
        
        for(int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            
            if('A'<= temp) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}