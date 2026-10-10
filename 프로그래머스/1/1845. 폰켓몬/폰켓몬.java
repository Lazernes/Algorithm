import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        int answer = 0;
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int temp = hashMap.getOrDefault(nums[i], 0);
            hashMap.put(nums[i], temp + 1);
        }
        
        if(N/2 <= hashMap.keySet().size()) {
            answer = N/2;
        } else {
            answer = hashMap.keySet().size();
        }
                
        return answer;
    }
}