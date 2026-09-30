import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] stringNums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            stringNums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(stringNums, (a, b) -> (b + a).compareTo(a + b)); // 문자열을 더한 값이 큰 순서대로 정렬(내림차순)

        // 만약 가장 큰 값이 "0"이면, 모든 값이 0이므로 "0"을 반환
        if (stringNums[0].equals("0")) {
            return "0";
        }
        
        for(int i=0; i<numbers.length; i++) {
            answer += stringNums[i];
        }
        
        return answer;
    }
}