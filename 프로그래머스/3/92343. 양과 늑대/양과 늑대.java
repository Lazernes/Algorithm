import java.util.*;

class Solution {
    
    int maxSheepCount = 0;
    boolean[] isVisted;
    
    public int solution(int[] info, int[][] edges) {
        
        isVisted = new boolean[info.length];
        
        DFS(0, isVisted, 0, 0, info, edges);
        
        return maxSheepCount;
    }
    
    private void DFS(int index, boolean[] isVisted, int sheepCount, int wolfCount, int[] info, int[][] edges) {
        isVisted[index] = true;
        
        if(info[index] == 0) {
            sheepCount++;
            
            maxSheepCount = Math.max(maxSheepCount, sheepCount);
        } else {
            wolfCount++;
        }
        
        if(sheepCount <= wolfCount) {
            return;
        }
        
        for(int[] edge: edges) {
            if(isVisted[edge[0]] && !isVisted[edge[1]]) {
                boolean[] newIsVisted = isVisted.clone();
                DFS(edge[1], newIsVisted, sheepCount, wolfCount, info, edges);
            }
        }
        
        
    }
}