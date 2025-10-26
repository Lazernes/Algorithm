class Solution {
    
    static int[][] answer;
    static int index;
    
    public int[][] solution(int n) {
        int hanoiIter = (int) (Math.pow(2, n));
        answer = new int[hanoiIter-1][2];
        index = 0;
        
        Hanoi(n, 1, 2, 3);
        
        return answer;
    }
    
    static void Hanoi(int n, int start, int mid, int to) {
        
        if(n==1) {
            answer[index][0] = start;
            answer[index][1] = to;
            index++;
            return;
        }
        
        // n-1개를 1번 원판에서 2번 원판으로 이동
        Hanoi(n-1, start, to, mid);
        // 1개를 1번 원판에서 3번 원판으로 이동
        answer[index][0] = start;
        answer[index][1] = to;
        index++;
        // n-1개를 2번 원판에서 3번 원판으로 이동
        Hanoi(n-1, mid, start, to);
    }
}