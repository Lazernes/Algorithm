class Solution {
    
    static boolean[] isVisted;
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        
        isVisted = new boolean[numbers.length];
        
        DFS(numbers, 0, target, 0, 1);
        DFS(numbers, 0, target, 0, -1);
        
        
        return count;
    }
    
    static void DFS(int[] numbers, int index, int target, int sum, int symbol) {
        sum += numbers[index] * symbol;

        if(index == isVisted.length - 1) {
            if(sum == target) {
                count++;
            }
        } else {
            index++;
        
            DFS(numbers, index, target, sum, 1);
            DFS(numbers, index, target, sum, -1);

        }
                
    }
}