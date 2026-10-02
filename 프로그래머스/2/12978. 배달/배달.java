import java.util.*;

class Solution {
    // 노드와 가중치(시간)를 담을 클래스
    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public int solution(int N, int[][] road, int K) {
        // 인접 리스트 초기화
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 도로 정보 입력
        for (int[] r : road) {
            int u = r[0];
            int v = r[1];
            int w = r[2];
            // 양방향 연결
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        // 최단 거리 배열 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 다익스트라 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0)); // 1번 마을에서 시작, 거리 0
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            int w = current.weight;

            if (dist[u] < w) continue;

            for (Node neighbor : graph.get(u)) {
                int nextVertex = neighbor.vertex;
                int nextWeight = w + neighbor.weight;

                // 더 짧은 경로가 발견된 경우 갱신
                if (nextWeight < dist[nextVertex]) {
                    dist[nextVertex] = nextWeight;
                    pq.add(new Node(nextVertex, nextWeight));
                }
            }
        }

        // K 시간 이하로 배달 가능한 마을 개수 카운트
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}