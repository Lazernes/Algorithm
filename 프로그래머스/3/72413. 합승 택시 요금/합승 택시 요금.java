import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Node>> maps = new ArrayList<>();
    static int INF = Integer.MAX_VALUE;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        for(int i=0;i<n+1;i++) {
            maps.add(new ArrayList<>());
        }
        
        for(int i=0;i<fares.length;i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int weights = fares[i][2];
            
            maps.get(start).add(new Node(end, weights));
            maps.get(end).add(new Node(start, weights));
        }
        
        // 각각의 Node에서 다른 Node까지의 최단거리
        int[] distS = Dijkstra(s, n);
        int[] distA = Dijkstra(a, n);
        int[] distB = Dijkstra(b, n);
        
        int min = INF;
        for(int i=1;i<=n;i++) {
            int together = distS[i];
            int A = distA[i];
            int B = distB[i];
            
            if(together + A + B <min) {
                min = together + A + B;
            }
        }
        
        answer = min;
        return answer;
    }
    
    static int[] Dijkstra(int start, int n) {
        int[] d = new int[n + 1];
        boolean[] Visit = new boolean[n + 1];
        
        Arrays.fill(d, INF);
        d[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(); 
        pq.add(new Node(start, 0));
            
        while(!pq.isEmpty()){
            Node current = pq.poll();
            Visit[current.v] = true;
                
            for(int j=0; j<maps.get(current.v).size();j++) {
                Node next = maps.get(current.v).get(j);
                int nextNode = next.v;
                int nextWeight = next.w;
                    
                if(Visit[nextNode]) {
                    continue;
                }
                        
                if(d[current.v] + nextWeight < d[nextNode]) {
                    d[nextNode] = d[current.v] + nextWeight;
                    pq.add(new Node(nextNode, d[nextNode]));
                }
                    
            }        
        }
        
        return d;
    }
    
    static class Node implements Comparable<Node> {
        int v;
        int w;
        
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
        
    }
}