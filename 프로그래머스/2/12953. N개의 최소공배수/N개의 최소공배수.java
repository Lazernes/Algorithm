class Solution {
    public int solution(int[] arr) {
        int gcd = GCD(arr[0], arr[1]);
        int answer = (arr[0] * arr[1]) / gcd; // 처음 두 수의 최소공배수
        
        for(int i=2;i<arr.length;i++){
            gcd = GCD(answer, arr[i]);
            answer = (answer * arr[i]) / gcd;
        }
        
        return answer;
    }
    
    static int GCD(int a, int b) {
        if(b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        while(a%b!=0) {
            int r = a%b;
            a = b;
            b = r;
        }
        
        return b;
    }
}