class Solution {
    
    static boolean[] Visit;
    static int[][] PCs;
    static int N;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Visit = new boolean[n];
        N = n;
        
        PCs = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                PCs[i][j] = computers[i][j];
            }
        }
        
        for(int i=0;i<n;i++) {
            if(!Visit[i]) {
                DFS(i);
                answer++;
            }
        }
        
        
        return answer;
    }
    
    static void DFS(int n) {
        Visit[n] = true;
        
        for(int i=0;i<N;i++) {
            if(PCs[n][i] == 1 && !Visit[i]){
                DFS(i);
            }
        }
    }
}