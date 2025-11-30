class Solution {
    static int mod = 1234567;
    
    public long solution(int n) {
        long answer = 0;
        
        int[] arr = new int[2001];
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3; i<2001;i++) {
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] %= mod;
        }
        
        answer = arr[n];
        return answer;
    }
    
}