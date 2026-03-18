class Solution {
    public String solution(String s) {
        String answer = "";
        
        int index = 1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            String a = String.valueOf(c);
            
            if(c == ' ') {
                index = 1;
                answer += " ";
                continue;
            }
            
            if(index%2 == 0) {
                a = a.toLowerCase();
            } else {
                a = a.toUpperCase();
            }
            
            answer += a;
            index++;
        }
        
        return answer;
    }
}