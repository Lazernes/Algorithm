class Solution {
    
    static int answer = 0;
    static boolean[] isVisted;
    
    public int solution(int k, int[][] dungeons) {
        
        isVisted = new boolean[dungeons.length];
        
        DFS(0, k, dungeons);
        
        return answer;
    }
    
    static void DFS(int depth, int k, int[][] dungeons) {
        
        for(int i=0; i<dungeons.length; i++) {
            
            if(!isVisted[i] && dungeons[i][0] <= k) {
                isVisted[i] = true;
                DFS(depth + 1, k - dungeons[i][1], dungeons);
                isVisted[i] = false;
            }
        }
        
        answer = Math.max(answer, depth);
    }

}