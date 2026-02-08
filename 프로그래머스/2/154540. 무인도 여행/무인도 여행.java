import java.util.*;

class Solution {
    
    static boolean[][] visit;
    static int[][] arr;
    
    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1};
    
    public int[] solution(String[] maps) {
        
        arr = new int[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length();j++) {
                if(maps[i].charAt(j) != 'X') {
                    arr[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length();j++) {
                if(arr[i][j] != 0 && !visit[i][j]) {
                    int a = BFS(i,j);
                    ans.add(a);
                }
            }
        }
        
        if(ans.size() == 0) {
            int[] a = {-1};
            return a;
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i).intValue();
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    static private int BFS(int a, int b) {
        
        int sum = 0;
        Queue<Node> qu = new LinkedList<>();
        
        qu.add(new Node(a, b));
        visit[a][b] = true;
        
        while(!qu.isEmpty()) {
            Node cur = qu.poll();
            sum += arr[cur.x][cur.y];
            
            for(int i=0; i<4;i++) {
                if(cur.x + y[i] >=0 && cur.x + y[i] <arr.length && cur.y + x[i] >=0 && cur.y + x[i] <arr[0].length) {
                    if(!visit[cur.x + y[i]][cur.y + x[i]] && arr[cur.x + y[i]][cur.y + x[i]] !=0) {
                        qu.add(new Node(cur.x + y[i], cur.y + x[i]));
                        visit[cur.x + y[i]][cur.y + x[i]] = true;
                    }
                }
            }
                
        }
        
        return sum;
    }
    
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}