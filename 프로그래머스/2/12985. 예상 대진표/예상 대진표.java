class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
                
        while(true) {
            
            answer++;
            
            if(a % 2 == 1 && a + 1 == b) {
                break;
            }
            
            if(a % 2 == 0) {
                a = a/2;
            } else {
                a = a/2 + 1;
            }
            
            if(b % 2 == 0) {
                b = b/2;
            } else {
                b = b/2 + 1;
            }
        }

        return answer;
    }
}