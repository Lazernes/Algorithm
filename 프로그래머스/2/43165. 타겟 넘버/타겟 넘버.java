class Solution {
    
    static boolean[] visited;
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        
        visited = new boolean[numbers.length];
        
        DFS(numbers, 0, target, 0, 1);
        DFS(numbers, 0, target, 0, -1);
        
        return count;
    }
    
    
    static void DFS(int[] numbers, int index, int target, int sum, int symbol) {
        
        if(index == visited.length - 1) {
            if(sum + (symbol * numbers[index]) == target) {
                count++;
            }
            
            return;
        }
        
        int partSum = sum + symbol * numbers[index];
        DFS(numbers, index + 1, target, partSum, 1);
        DFS(numbers, index + 1, target, partSum, -1);
    }
}