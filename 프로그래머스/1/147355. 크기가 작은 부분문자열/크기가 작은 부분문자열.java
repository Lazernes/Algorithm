class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int tLen = t.length();
        int pLen = p.length();
        Long pInt = Long.parseLong(p);
        
        for(int i=0; i<tLen-pLen+1; i++) {
            String subT = t.substring(i,i+pLen);
            Long temp = Long.parseLong(subT);
            
            if(temp <= pInt) {
                answer++;
            }
        }
        
        return answer;
    }
}