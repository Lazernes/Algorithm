import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> company = new ArrayList<>();
    
    // DP[i][0]: 직원 i가 워크숍에 참여하지 않았을 때, 매출액 합의 최솟값
    // DP[i][1]: 직원 i가 워크숍에 참여했을 때, 매출액 합의 최솟값
    static int[][] DP = new int[300001][2]; 
    
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        
        for(int i=0; i<=sales.length; i++) {
            company.add(new ArrayList<>());
        }
        
        for(int i=0; i<links.length; i++) {
            int leader = links[i][0];
            int member = links[i][1];
            
            company.get(leader).add(member);
        }
                
        DFS(1, sales);
        answer = Math.min(DP[1][0], DP[1][1]);
        
        return answer;
    }
    
    static void DFS(int n, int[] sales) {
        DP[n][0] = 0;
        DP[n][1] = sales[n-1];
        
        if(company.get(n).size() == 0) {
            return;
        }
        
        int extra = Integer.MAX_VALUE;
        
        for(int i=0; i<company.get(n).size(); i++) {
            int member = company.get(n).get(i);
            DFS(member, sales);
            
            if(DP[member][0] < DP[member][1]) {
                DP[n][0] += DP[member][0];
                DP[n][1] += DP[member][0];
                
                extra = Math.min(extra, DP[member][1] - DP[member][0]);
            } else {
                DP[n][0] += DP[member][1];
                DP[n][1] += DP[member][1];
                
                extra = 0;
            }
        }
        
        DP[n][0] += extra;
    }
    
}