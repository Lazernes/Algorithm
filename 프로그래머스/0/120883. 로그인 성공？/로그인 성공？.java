import java.util.*;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer;
        
        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<db.length;i++) {
            map.putIfAbsent(db[i][0], db[i][1]);
        }
        
        if(map.get(id_pw[0]) != null) {
            if(id_pw[1].equals(map.get(id_pw[0]))) {
                answer = "login";
            } else {
                answer = "wrong pw";
            }
        } else {
            answer = "fail";
        }
        
        return answer;
    }
}