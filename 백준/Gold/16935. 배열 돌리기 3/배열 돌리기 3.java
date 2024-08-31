import java.io.*;
import java.util.*;

public class Main {
    // static int[][]map;
    // static int[][]nextMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<R; i++) {
            int t = Integer.parseInt(st.nextToken());

            switch (t) {
                case 1:
                    map = reflextionUD(map);
                    break;
                case 2:
                    map = reflextionLR(map);
                    break;
                case 3:
                    map = clockwise(map);
                    break;
                case 4:
                    map = counterClockwise(map);
                    break;
                case 5:
                    map = rollClockwise(map);
                    break;
                case 6:
                    map = rollCounterClockwise(map);
                    break;
                }
        }
        printMap(map);
    }

    static void printMap(int[][]map) {
        int N = map.length;
        int M = map[0].length;

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                sb.append(map[y][x] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static int[][] reflextionLR(int[][] map) {
        int N = map.length;
        int M = map[0].length;
        int[][] nextMap = new int[N][M];
        
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                nextMap[y][M-1-x] = map[y][x];
            }
        }
        return nextMap;
    }

    static int[][] reflextionUD(int[][] map) {
        int N = map.length;
        int M = map[0].length;
        int[][] nextMap = new int[N][M];
        
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                nextMap[N-1-y][x] = map[y][x];
            }
        }

        return nextMap;
    }

    static int[][] transepose(int[][] map) {
        int N = map.length;
        int M = map[0].length;
        int[][] nextMap = new int[M][N];
        
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                nextMap[x][y] = map[y][x];
            }
        }
        return nextMap;
    }

    static int[][] counterClockwise(int[][] map) {
        return reflextionUD(transepose(map));
    }

    static int[][] clockwise(int[][] map) {
        return transepose(reflextionUD(map));
    }

    static int[][] rollCounterClockwise(int[][] map) {
        int N = map.length;
        int M = map[0].length;
        int[][] nextMap = new int[N][M];
        
        // 1 -> 4
        for (int y = 0; y < N/2; y++) {
            for (int x = 0; x < M/2; x++) {
                nextMap[y + N/2][x] = map[y][x];
            }
        }

        // 2 -> 1
        for (int y = 0; y < N/2; y++) {
            for (int x = M/2; x < M; x++) {
                nextMap[y][x - M/2] = map[y][x];
            }
        }

        // 3 -> 2
        for (int y = N/2; y < N; y++) {
            for (int x = M/2; x < M; x++) {
                nextMap[y - N/2][x] = map[y][x];
            }
        }

        // 4 -> 3
        for (int y = N/2; y < N; y++) {
            for (int x = 0; x < M/2; x++) {
                nextMap[y][x + M/2] = map[y][x];
            }
        }

        return nextMap;
    }
    static int[][] rollClockwise(int[][] map) {
        int N = map.length;
        int M = map[0].length;
        int[][] nextMap = new int[N][M];
        
        // 1 -> 2
        for (int y = 0; y < N/2; y++) {
            for (int x = 0; x < M/2; x++) {
                nextMap[y][x + M/2] = map[y][x];
            }
        }

        // 2 -> 3
        for (int y = 0; y < N/2; y++) {
            for (int x = M/2; x < M; x++) {
                nextMap[y+ N/2][x] = map[y][x];
            }
        }

        // 3 -> 4
        for (int y = N/2; y < N; y++) {
            for (int x = M/2; x < M; x++) {
                nextMap[y][x - M/2] = map[y][x];
            }
        }

        // 4 -> 1
        for (int y = N/2; y < N; y++) {
            for (int x = 0; x < M/2; x++) {
                nextMap[y - N/2][x] = map[y][x];
            }
        }

        return nextMap;
    }
}
