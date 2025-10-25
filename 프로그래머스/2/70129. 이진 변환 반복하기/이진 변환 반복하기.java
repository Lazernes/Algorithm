class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int zeroCount = 0;
        int iter = 0;
        
        while(s.length() > 1) {
            int oneCount = 0;
            for(int i=0;i<s.length();i++) {
                char temp = s.charAt(i);
                if(temp == '1') {
                    oneCount++;
                } else{
                    zeroCount++;
                }
            }
            
            String x = "";
            int digit = 1;
            while(digit <= oneCount) {
                digit*=2;
            }
            
            for(int i=digit/2; i>=1;i/=2) {
                if(oneCount >= i) {
                    x+="1";
                    oneCount -= i;
                } else{
                    x+="0";
                }
            }
            
            s = x;
            iter++;
        }
        
        answer[0] = iter;
        answer[1] = zeroCount;
        
        return answer;
    }
}