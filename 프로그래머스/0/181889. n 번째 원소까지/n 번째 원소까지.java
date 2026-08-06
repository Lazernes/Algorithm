import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            arr.add(num_list[i]);
        }
        
        int[] array = new int[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            array[i] = arr.get(i);
    }
        
        return array;
    }
}