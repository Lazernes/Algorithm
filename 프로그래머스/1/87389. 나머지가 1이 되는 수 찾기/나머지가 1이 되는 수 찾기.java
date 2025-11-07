class Solution {
    public int solution(int n) {
        int answer = 0;
        int div = 2;
        while(answer == 0) {
            if(n%div == 1) {
                answer = div;
            } else {
                div++;
            }
        }
        
        return answer;
    }
}