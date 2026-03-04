import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length;i++) {
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        
        if(list.size() == 0) {
            int[] temp = {-1};
            return temp;
        }
        
        int[] answer = list.stream()
            .mapToInt(i ->i)
            .toArray();
        
        return answer;
    }
}