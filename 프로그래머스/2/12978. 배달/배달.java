class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] dist = new int[N+1][N+1];
        int INF = 500000;
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }
        
        for(int[] r: road) {
            int u = r[0];
            int v = r[1];
            int w = r[2];
            
            if(dist[u][v] > w) {
                dist[u][v] = w;
                dist[v][u] = w;
            }
        }
        
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        for(int i=1; i<=N; i++) {
            if(dist[1][i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}