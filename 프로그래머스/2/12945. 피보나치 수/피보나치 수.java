class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] F = new int[100001];
        F[0] = 0;
        F[1] = 1;
        
        for(int i=2;i<n+1;i++) {
            F[i] = (F[i - 1] + F[i - 2])%1234567;
        }
        
        answer = F[n];
        
        return answer;
    }
}