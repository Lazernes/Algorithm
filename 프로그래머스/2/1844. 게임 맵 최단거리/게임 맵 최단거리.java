import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static int[][] M;
    static boolean[][] Visit;
    static int n;
    static int m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        
        M = new int[n][m];
        Visit = new boolean[n][m];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                M[i][j] = maps[i][j];
            }
        }
        
        BFS(0,0);
        
        if(!Visit[n - 1][m - 1]) {
            answer = -1;
        } else{
            answer = M[n-1][m-1];
        }
        
        return answer;
    }
    
    static void BFS(int a, int b) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(a,b));
        Visit[a][b] = true;
        
        while(!qu.isEmpty()) {
            Node currentNode = qu.poll();
            int currentX = currentNode.a;
            int currentY = currentNode.b;
            
            if(currentX == n - 1 && currentY == m - 1) {
                break;
            }
            
            for(int i=0;i<4;i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                
                if(nextX >= 0 && nextX < n && nextY >=0 && nextY < m) {
                    if(M[nextX][nextY] == 1 && !Visit[nextX][nextY]) {
                        qu.add(new Node(nextX, nextY));
                        Visit[nextX][nextY] = true;
                        M[nextX][nextY] = M[currentX][currentY] + 1;
                    }
                }
            }
            
        }
        
        
    }
    
    static class Node {
        int a;
        int b;
        
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}