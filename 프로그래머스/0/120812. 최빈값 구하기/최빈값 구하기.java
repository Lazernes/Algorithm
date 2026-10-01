import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        int[] arr = new int[1000];
        
        for(int i=0; i<array.length; i++) {
            arr[array[i]]++;
        }
        
        for(int i=0; i<1000; i++) {
            if(arr[answer] < arr[i]) {
                answer = i;
            }
        }
        
        int count = 0;
        
        for(int i=0; i<1000; i++) {
            
            if(arr[i] == arr[answer]) {
                count++;
            }
            
        }
        
        if(count!=1) {
            return -1;
        }
        
        return answer;
    }
}