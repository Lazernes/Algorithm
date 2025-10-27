class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1;i<=yellow;i++) {
            if(yellow % i == 0) {
                int w = i;
                int h = yellow / i;
                
                if(w*2 + h*2 + 4 == brown) {
                    if(w<h) {
                        int temp = h;
                        h = w;
                        w = temp;
                    }
                    
                    answer[0] = w+2;
                    answer[1] = h+2;
                }
            }
        }
        
        return answer;
    }
}