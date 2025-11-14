class Solution {
    public int[] solution(long n) {
        String st = String.valueOf(n);
        int[] answer = new int[st.length()];
        
        for(int i=0;i<st.length();i++) {
            answer[i] = (int)( n % 10 );
            n/=10;
        }
        
        return answer;
    }
}