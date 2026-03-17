class Solution {
    public int solution(int n) {
        
        String n3 = "";
        
        while(n > 0) {
            n3 += n%3;
            n/=3;
        }
        
        int answer = Integer.parseInt(n3, 3);
        return answer;
    }
}