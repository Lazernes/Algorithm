class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        boolean isFirst = true;
        
        for(int i=0;i<s.length();i++) {
            char current = s.charAt(i);
            
            if(isFirst) {
                if(current >= 'a' && current <='z') {
                    current = (char) ((current - 'a') + 'A');
                }
                isFirst = false;
            }
            
            answer += String.valueOf(current);
            if(Character.isWhitespace(current)) {
                isFirst = true;
            }
        }
        
        return answer;
    }
}