import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);
        // 1 2 2 3 3 4 5 5
        int sizeIndex = 0;
        Integer[] size = new Integer[tangerine.length];
        Arrays.fill(size, 0);
        int preSize = tangerine[0];
        size[0]++;
        
        for(int i=1; i<tangerine.length;i++) {
            if(tangerine[i] == preSize) {
                size[sizeIndex]++;
            } else {
                preSize = tangerine[i];
                size[++sizeIndex]++;
            }
        }
        
        Arrays.sort(size, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        // 2 2 2 1 1
        
        sizeIndex = 0;
        while(k>0) {
            k -= size[sizeIndex++];
            answer++;
        }
        
        
        
        return answer;
    }
}