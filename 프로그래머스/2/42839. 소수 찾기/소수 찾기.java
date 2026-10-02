import java.util.*;

class Solution {
    
    Set<Integer> sets = new HashSet<>();
    boolean[] visited = new boolean[7];
    
    public int solution(String numbers) {
        int answer = 0;

        dfs(numbers, "", 0);
        
        for(Integer set: sets) {
            if(isPrime(set)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(String numbers, String s, int depth) {
        
        if(depth == numbers.length()) {
            return;
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                sets.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        
		// 에라토스테네스 체
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
 
        return true;
    }
}