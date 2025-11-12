class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int p = 0;
        int y = 0;
        
        for(int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            
            if(temp == 'p' || temp == 'P') {
                p++;
            } else if(temp=='y'||temp=='Y') {
                y++;
            }
        }

        if(p!=y) {
            answer = false;
        }
        
        return answer;
    }
}