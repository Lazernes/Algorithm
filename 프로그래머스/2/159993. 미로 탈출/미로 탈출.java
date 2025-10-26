import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static int[][] Maps;
    static boolean[][] Visit;
    static int n;
    static int m;
    static int answer;
    
    public int solution(String[] maps) {
        answer = 0;
        
        n = maps.length;
        m = maps[0].length();
        Maps = new int[n][m];
        
        int startX = 0;
        int startY = 0;
        int leverX = 0;
        int leverY = 0;
        int exitX = 0;
        int exitY = 0;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                char temp = maps[i].charAt(j);
                
                if(temp == 'S') {
                    startX = i;
                    startY = j;
                } else if(temp == 'L') {
                    leverX = i;
                    leverY = j;
                } else if(temp == 'E') {
                    exitX = i;
                    exitY = j;
                }
                
                if(temp != 'X') {
                    Maps[i][j] = 0; // 이동할 수 있는 칸
                } else {
                    Maps[i][j] = -1; // 이동할 수 없는 칸
                }
                
            }
        }
        
        if(!BFS(startX, startY, leverX, leverY)) {
            return -1;
        }
        
        if(!BFS(leverX, leverY, exitX, exitY)){
            return -1;
        }
        
        answer = Maps[exitX][exitY];
        
        return answer;
    }
    
    static class Node{
        int a;
        int b;
        
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    static boolean BFS(int sA, int sB, int tA, int tB) {   // s: 시작위치, t: 타깃위치
        Queue<Node> qu = new LinkedList<>();
        Visit = new boolean[n][m];
        
        qu.add(new Node(sA, sB));
        Visit[sA][sB] = true;
        
        while(!qu.isEmpty()) {
            Node currentNode = qu.poll();
            int currentA = currentNode.a;
            int currentB = currentNode.b;
            
            for(int i=0;i<4;i++) {
                int nextA = currentA + dx[i];
                int nextB = currentB + dy[i];
                
                if(nextA >=0 && nextA < n && nextB >= 0 && nextB < m) {
                    if(Maps[nextA][nextB] != -1 && !Visit[nextA][nextB]) {
                        qu.add(new Node(nextA, nextB));
                        Visit[nextA][nextB] = true;
                        Maps[nextA][nextB] = Maps[currentA][currentB] + 1;
                    }
                }
            }
        }
        
        if(Visit[tA][tB]) {
            return true;
        } else {
            return false;
        }
        
    }
}