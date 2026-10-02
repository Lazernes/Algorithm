import java.util.*;

class Solution {
    
    public int[] solution(int[] answers) {
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] ans = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == arr1[i % 5]) {
                ans[0]++;
            }
            
            if(answers[i] == arr2[i % 8]) {
                ans[1]++;
            }
            
            if(answers[i] == arr3[i % 10]) {
                ans[2]++;
            }
        }

        int max = Math.max(ans[0], ans[1]);
        max = Math.max(max, ans[2]);
        
        int count = 0;
        
        for(int i=0; i<3; i++) {
            if(ans[i] == max) {
                count++;
            }
        }
        
        int[] answer = new int[count];
        
        int index = 0;
        for(int i=0; i<3; i++) {
            if(ans[i] == max) {
                answer[index] = i + 1;
                index++;
            }
        }
        
        return answer;
    }
}