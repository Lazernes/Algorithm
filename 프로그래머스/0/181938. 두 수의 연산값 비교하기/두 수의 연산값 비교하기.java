class Solution {
    public int solution(int a, int b) {
        int answer = 2*a*b;
        
        String sA = a + "";
        String sB = b + "";
        String s = sA + sB;
        int temp = Integer.parseInt(s);
        
        if(temp > answer) {
            answer = temp;
        }
        
        return answer;
    }
}