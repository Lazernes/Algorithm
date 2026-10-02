class Solution {
    public int solution(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[a-zA-Z]","");
        
        for(int i=0; i<my_string.length(); i++) {
            int temp = Integer.parseInt(Character.toString(my_string.charAt(i)));
            answer += temp;
        }
        
        return answer;
    }
}