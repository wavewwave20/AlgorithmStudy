import java.util.*;
import java.io.*;

public class Solution {
    static int N,M,C;
    static int[][]map;
    static int maxHoney;
    static int maxHoney1;
    static int maxHoney2;

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        
        for(int T = 1; T<=tc ; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
           
            map = new int[N][N];
            for(int y = 0; y<N; y++){
                st = new StringTokenizer(br.readLine());
                for(int x = 0; x<N; x++){
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            int maxHoney = 0;
            for(int i = 0; i<N*N; i++) {
                for(int j = i+M; j < N*N; j++) {
                    int iy = i/N;
                    int ix = i%N;
    
                    if(ix + M > N) {
                        continue;
                    }
    
                    int jy = j/N;
                    int jx = j%N;
    
                    if(jx + M > N) {
                        continue;
                    }
                    maxHoney1 = 0;
                    maxHoney2 = 0;
                    generateSubset(0, 0, new boolean[M], ix, iy, 1);
                    generateSubset(0, 0, new boolean[M], jx, jy, 2);

                    if(maxHoney < maxHoney1 + maxHoney2) {
                        maxHoney = maxHoney1 + maxHoney2;
                    }
                }
            }

            sb.append("#").append(T + " ").append(maxHoney).append("\n");
        }
        System.out.println(sb.toString());

    }

    static int getHoney(int x, int y, boolean[] check) {
        int cnt = 0;
        int honey = 0;
        for(int i = 0; i< check.length; i++) {
            if(check[i]) {
                cnt += map[y][x+i];
                if(cnt > C) {
                    return -1;
                }
                honey += map[y][x+i] * map[y][x+i];
                // System.out.println(map[y][x+i]);
            }

        }

        if(cnt <= C ) {
            return honey;
        }
        return -1;
    }

    static void generateSubset(int count, int index, boolean[] check, int x, int y, int employeeNum) {
        if(index == M) {
            int tmp = getHoney(x, y, check);
            if(tmp != -1) {
                if(employeeNum == 1 && maxHoney1 < tmp) {
                    maxHoney1 = tmp;
                }else if(employeeNum == 2 && maxHoney2 < tmp){
                    maxHoney2 = tmp;
                }
            }
            return;
        }
        

        check[index] = true;
        generateSubset(count+1,index+1, check, x, y, employeeNum);
        check[index] = false;

        generateSubset(count, index+1, check, x, y, employeeNum);
    }


}
