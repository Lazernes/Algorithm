import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int twoBoat = 0;
        
        while(left < right) {
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
                twoBoat++;
            } else {
                right--;
            }
        }
        
        
        return people.length - twoBoat;
    }
}