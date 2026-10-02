import java.util.*;

class Solution {
    
    int answer;
    int N;
    int M;
    
    boolean[][] visited;
    int[] x = {1, -1, 0, 0};
    int[] y = {0, 0, 1, -1};
    
    static class Node {
        int a;
        int b;
        
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    public int solution(int[][] maps) {
        
        N = maps.length;
        M = maps[0].length;

        answer = N*M + 1;
        visited = new boolean[N][M];
        
        visited[0][0] = true;
        bfs(0, 0, maps);
        
        if(visited[N-1][M-1]) {
            answer = maps[N-1][M-1];
        } else {
            answer = -1;
        }
        
        return answer;
    }
    
    private void bfs(int a, int b, int[][] maps) {
        
        Queue<Node> qu = new LinkedList<>();
        qu.offer(new Node(a,b));
        
        while(!qu.isEmpty()) {
            Node node = qu.poll();
            
            int n = node.a;
            int m = node.b;
            
            if(n == N-1 && m == M-1) {
                break;
            }
            
            visited[n][m] = true;
            
            for(int i=0; i<4; i++) {
                
                int nextN = n + x[i];
                int nextM = m + y[i];
                
                if(nextN < 0 | nextN >=N | nextM < 0 | nextM >= M) {
                    continue;
                }
                
                if(!visited[nextN][nextM] && maps[nextN][nextM] != 0) {
                    maps[nextN][nextM] = maps[n][m] + 1;
                    visited[nextN][nextM] = true;
                    qu.offer(new Node(nextN, nextM));
                }
            }
        }
        
        
       
    }
}