import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(int[][] land) {
        int answer = 0;
        
        int [][] visited = new int[land.length][land[0].length];
        int [][] oil = new int[land.length][land[0].length];
            
        int oilIndex = 1;
        int[] oilCount = new int[500 * 500];
 
        for (int i = 0; i<land.length; i++){
            for (int j = 0; j<land[0].length; j++){

                if(land[i][j] == 1 && visited[i][j] == 0) {
                    dfs(new int[] {i,j},land,visited,oil,oilIndex++, oilCount);
                }
            }
        }
        
        int[] oilCoulmn = new int[land[0].length];
        for (int i = 0; i<land[0].length; i++){
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j<land.length; j++){
                if (oil[j][i] == 0) {
                    continue;
                }
                set.add(oil[j][i]);
            }
            for (int j : set){
                oilCoulmn[i] += oilCount[j];
            }
        }

        for (int i: oilCoulmn){
            if (i > answer) {
                answer = i;
            }
        }
        return answer;
    }

    void dfs(int[] curren, int[][] land, int[][] visited, int[][] oil, int oilIndex, int[] oilCount) {
        Stack<int[]> stack = new Stack<>();

        // 출발 지점을 스택에 추가
        stack.push(new int[] {curren[0], curren[1]});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int y = current[0];
            int x = current[1];

            // 방문 여부 확인
            if (visited[y][x] == 1 || land[y][x] == 0) {
                continue;
            }

            // 현재 위치 방문 처리
            visited[y][x] = 1;
            oil[y][x] = oilIndex;
            oilCount[oilIndex]++;

            // 이웃한 정점 스택에 추가
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < land.length && nx < land[0].length) {
                    stack.push(new int[] {ny, nx});
                }
            }
        }
    }
}