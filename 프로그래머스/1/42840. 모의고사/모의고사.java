import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        
        int[][] supo = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        
        int[] supoIndex = new int[3];
        
        int[] supoScore = new int[3];
        
        for(int i : answers) {
            for(int s = 0; s<3; s++) {
                if(supo[s][supoIndex[s]] == i) {
                    supoScore[s]++;
                }
                supoIndex[s]++;
                if(supoIndex[s] >= supo[s].length) {
                    supoIndex[s] = 0;
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i<3; i++) {
            if(supoScore[i] > max) {
                max = supoScore[i];
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<3; i++) {
            if(max == supoScore[i]) {
                list.add(i+1);
            }
        }
        
        answer = new int [list.size()];
        
        for(int i =0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}