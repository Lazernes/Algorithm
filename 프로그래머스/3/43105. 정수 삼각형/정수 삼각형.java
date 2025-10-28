class Solution {

    static int[][] D; // D[i][j]: i번째 층에서 j번째 숫자를 뽑았을 때 최대값
    
    public int solution(int[][] triangle) {
        int answer = 0;
        
        D = new int[triangle.length][triangle.length];
        D[0][0] = triangle[0][0];
        int max = 0;
        
        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                if(j==0) {
                    D[i][j] = D[i - 1][0] + triangle[i][j];
                } else if(j == triangle[i].length - 1) {
                    D[i][j] = D[i - 1][triangle[i - 1].length - 1] + triangle[i][j];
                } else {
                    D[i][j] = Math.max(D[i - 1][j - 1], D[i - 1][j]) + triangle[i][j];
                }
                
                if(D[i][j] > max) {
                    max = D[i][j];
                }
            }
        }
        
        answer = max;
        return answer;
    }
}