class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = oneCount(n);
        
        while(answer == 0) {
            if(oneCount(++n) == count) {
                answer = n;
            }
        }
        
        return answer;
    }
    
    static int oneCount(int n) {
        String BN = Integer.toBinaryString(n);
        int count = 0;
        
        for(int i=0;i<BN.length();i++) {
            if(BN.charAt(i) == '1'){
                count++;
            }
        }
        
        return count;
    }
}