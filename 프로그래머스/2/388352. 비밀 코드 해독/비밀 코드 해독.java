class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        for(int i=1;i<=n;i++) {
            for(int j=i+1;j<=n;j++) {
                for(int k=j+1;k<=n;k++) {
                    for(int l=k+1;l<=n;l++) {
                        for(int m=l+1;m<=n;m++) {
                            int[] pass = {i,j,k,l,m};
                            
                            if(isAble(pass, q, ans)) {
                                answer++;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    static boolean isAble(int[] pass, int[][] q, int[] ans) {
        boolean result = false;
        
        for(int i=0;i<q.length;i++) {
            int count = 0;
            
            for(int j=0;j<q[0].length;j++) {
                for(int k=0;k<5;k++) {
                    if(pass[k] == q[i][j]) {
                        count++;
                    }
                }
            }
            
            if(count != ans[i]) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        
        return result;
    }
}