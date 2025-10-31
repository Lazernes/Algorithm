import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] D;
    static boolean[] visit;
    static int INF = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        visit = new boolean[n+1];
        D = new int[n + 1];
        Arrays.fill(D, INF);
        D[0] = 0;
        D[1] = 0;
        
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<Node>());
        }
        
        for(int i=0; i<edge.length; i++) {
            int s = edge[i][0];
            int e = edge[i][1];
            int w = 1;
            
            graph.get(s).add(new Node(e, w));
            graph.get(e).add(new Node(s, w));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int current = node.e;
            visit[current] = true;
            
            for(int i=0; i<graph.get(current).size(); i++) {
                Node next = graph.get(current).get(i);
                
                if(visit[next.e]) {
                    continue;
                }
                
                if(D[next.e] > D[current] + next.w) {
                    D[next.e] = D[current] + next.w;
                    pq.add(new Node(next.e, D[next.e]));
                }
            }
        }
        
        Arrays.sort(D);
        int max = D[n];
        
        for(int i=0;i<D.length;i++) {
            if(D[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static class Node implements Comparable<Node> {
        int e;
        int w;
        
        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
}