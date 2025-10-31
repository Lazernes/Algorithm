class Solution {
    
    static class Buy {
        String P;
        int num;
        
        public Buy(String P, int num) {
            this.P = P;
            this.num = num;
        }
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Buy[] buy = new Buy[want.length];
        for(int i=0; i<want.length; i++) {
            buy[i] = new Buy(want[i], number[i]);
        }
        
        int iter = 10;  // number의 원소의 합
        
        for(int i=0; i<iter; i++) {
            String dis = discount[i];
            
            for(int j=0;j<buy.length; j++) {
                if(buy[j].P.equals(dis)) {
                    buy[j].num--;
                    break;
                }
            }
        }
        
        for(int i=0; i<=discount.length - iter; i++) {
            
            answer++;
            for(int j=0; j<buy.length; j++) {
                if(buy[j].num > 0) {
                    answer--;
                    break;
                }
            }
            
            if(i == discount.length - iter) {
                break;
            } 
            
            String pre = discount[i];
            String next = discount[i + iter];
            for(int j=0; j<buy.length; j++) {
                if(buy[j].P.equals(pre)) {
                    buy[j].num++;
                }
                
                if(buy[j].P.equals(next)) {
                    buy[j].num--;
                }
            }
        }
        
        return answer;
    }
}