import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Integer>> graph;
    boolean[] visit;
    int answer = 100;
    
    public int solution(int n, int[][] wires) {
        
        graph = new ArrayList<>();
        
        for(int i=0; i<n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire:wires) {
            int parent = wire[0];
            int child = wire[1];
            
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }
        
        for(int[] wire:wires) {
            int parent = wire[0];
            int child = wire[1];
            
            visit = new boolean[n+1];
            
            graph.get(parent).remove(Integer.valueOf(child));
            graph.get(child).remove(Integer.valueOf(parent));
            
            int diff = 0;
            
            for(int i=1; i<n+1; i++) {
                if(!visit[i]) {
                    // System.out.println("dfs(" + i + ", " + 1 + ") 실행");
                    if(diff == 0) {
                        diff = dfs(i, 0);
                    } else {
                        diff -=dfs(i,0);
                    }
                    // System.out.println(temp);
                }
            }
            
            diff = diff>=0?diff:diff*(-1);
            answer = Math.min(answer, diff);
            
            graph.get(parent).add(child);
            graph.get(child).add(parent);
            
        }
        
        return answer;
    }
    
    private int dfs(int index, int depth) { // 방문한 node 개수를 반환
        visit[index] = true;
        depth++;
        // System.out.println("index: " + index + "번 노드 방문");
        
        for(int i=0; i<graph.get(index).size(); i++) {
            if(!visit[graph.get(index).get(i)]) {
                depth = dfs(graph.get(index).get(i), depth);
            }
        }
        
        return depth;
    }
}