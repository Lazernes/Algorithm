import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int size = numbers.length;
        Arrays.sort(numbers);
        
        int answer = numbers[size - 1] * numbers[size - 2];
        return answer;
    }
}