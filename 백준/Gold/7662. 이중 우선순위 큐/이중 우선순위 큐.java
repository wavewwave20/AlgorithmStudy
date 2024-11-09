import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int T = 1; T <= TC; T++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                
                if (command.equals("I")) {
                    // 숫자를 삽입하고 등장 횟수를 증가시킴
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                } else if (command.equals("D") && !treeMap.isEmpty()) {
                    if (num == 1) {
                        // 최댓값 삭제
                        int maxKey = treeMap.lastKey();
                        if (treeMap.put(maxKey, treeMap.get(maxKey) - 1) == 1) {
                            treeMap.remove(maxKey);
                        }
                    } else {
                        // 최솟값 삭제
                        int minKey = treeMap.firstKey();
                        if (treeMap.put(minKey, treeMap.get(minKey) - 1) == 1) {
                            treeMap.remove(minKey);
                        }
                    }
                }
            }

            if (treeMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}
