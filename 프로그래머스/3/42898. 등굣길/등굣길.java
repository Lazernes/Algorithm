class Solution {
    
    static int MOD = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n + 1][m + 1];
        boolean[][] pudMap = new boolean[n + 1][m + 1];
        
        for(int i=0; i<puddles.length; i++) {
            int a = puddles[i][0];
            int b = puddles[i][1];

            pudMap[b][a] = true;
        }
            
        for(int i=1; i<n + 1; i++) {
            if(pudMap[i][1]) {
                break;
            }
            map[i][1] = 1;
        }
        
        for(int i=1; i<m + 1;i++) {
            if(pudMap[1][i]) {
                break;
            }
            map[1][i] = 1;
        }
        
        for(int i = 2; i<n+1; i++) {
            for(int j=2; j<m+1; j++) {
                if(!pudMap[i][j]) {
                    map[i][j] = (map[i-1][j] % MOD + map[i][j-1] % MOD) % MOD;
                }
            }
        }
        
        answer = map[n][m];
        
        return answer;
    }
}