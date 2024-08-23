import java.io.*;
import java.util.*;

class Point2 {
    int x, y, d;
    public Point2(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {
    static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상 순으로 이동
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
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

        int[][] result = rotateRtimes(R, map, N, M);

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                System.out.print(result[y][x] + " ");
            }
            System.out.println();
        }
    }

    // R번 회전을 수행하는 메서드
    static int[][] rotateRtimes(int R, int[][] map, int N, int M) {
        int[][] newMap = new int[N][M];

        int layers = Math.min(N, M) / 2; // 회전할 레이어 수 계산

        for (int i = 0; i < layers; i++) {
            int effectiveR = R % ((N - 2 * i) * 2 + (M - 2 * i) * 2 - 4); // 회전을 최소화
            rotateLayer(map, newMap, N, M, i, effectiveR); // 각 레이어 회전
        }

        return newMap;
    }

    // 하나의 레이어를 회전시키는 메서드
    static void rotateLayer(int[][] map, int[][] newMap, int N, int M, int layer, int R) {
        List<Integer> elements = new ArrayList<>();

        // 현재 레이어의 모든 요소를 가져옴
        for (int i = layer; i < M - layer; i++) elements.add(map[layer][i]); // 상단
        for (int i = layer + 1; i < N - layer; i++) elements.add(map[i][M - layer - 1]); // 우측
        for (int i = M - layer - 2; i >= layer; i--) elements.add(map[N - layer - 1][i]); // 하단
        for (int i = N - layer - 2; i > layer; i--) elements.add(map[i][layer]); // 좌측

        // 회전한 결과를 저장할 새로운 리스트 생성
        int len = elements.size();
        List<Integer> rotatedElements = new ArrayList<>(Collections.nCopies(len, 0));

        for (int i = 0; i < len; i++) {
            rotatedElements.set((i + (len - R)) % len, elements.get(i)); // 회전된 인덱스에 요소 배치
        }

        // 회전된 결과를 newMap에 저장
        int idx = 0;
        for (int i = layer; i < M - layer; i++) newMap[layer][i] = rotatedElements.get(idx++); // 상단
        for (int i = layer + 1; i < N - layer; i++) newMap[i][M - layer - 1] = rotatedElements.get(idx++); // 우측
        for (int i = M - layer - 2; i >= layer; i--) newMap[N - layer - 1][i] = rotatedElements.get(idx++); // 하단
        for (int i = N - layer - 2; i > layer; i--) newMap[i][layer] = rotatedElements.get(idx++); // 좌측
    }
}
