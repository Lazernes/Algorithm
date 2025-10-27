class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = Integer.bitCount(n);
        
        while(answer == 0) {
            if(Integer.bitCount(++n) == count) {
                answer = n;
            }
        }
        
        return answer;
    }
}