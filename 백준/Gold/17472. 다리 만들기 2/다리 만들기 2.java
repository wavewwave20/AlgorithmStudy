import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[] parent;
    static int V;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int y = 0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int index = 1;
        Queue<int[]> q = new ArrayDeque<>();
        boolean [][]visited = new boolean[N][M];


        for(int y = 0; y<N; y++) {
            for (int x = 0; x < M; x++) {
                if(!visited[y][x] && map[y][x] == 1) {

                    visited[y][x] = true;
                    map[y][x] = index;
                    q.add(new int[] {x,y,index++});

                    while(!q.isEmpty()) {
                        int[] now = q.poll();

                        int xx = now[0];
                        int yy = now[1];
                        int ii = now[2];

                        for(int i = 0; i<4; i++) {
                            int nx = xx + dx[i];
                            int ny = yy + dy[i];

                            if(nx<0 || ny<0 || nx>=M || ny>=N) {
                                continue;
                            }

                            if(!visited[ny][nx] && map[ny][nx] == 1) {
                                visited[ny][nx] = true;
                                map[ny][nx] = ii;
                                q.add(new int[] {nx, ny, ii});
                            }
                        }
                    }
                }
            }
        }

        // for(int y1 = 0; y1<N; y1++) {
        //     for (int x1 = 0; x1 < M; x1++) {
        //         System.out.print(map[y1][x1] + " ");
        //     }
        //     System.out.println();
        // }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.weight, b.weight));
        
        for(int y = 0; y<N; y++) {
            for (int x = 0; x < M; x++) {
                if(map[y][x] != 0) {
                    findEdge(pq, new int[]{x,y,map[y][x]}, map);
                }
            }
        }

        make(index - 1);
        int dist = 0;
        int count = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(union(edge.start, edge.end)) {
                dist+=edge.weight;
                count++;
            }
        }

        if (count != (V - 2)) { // V - 2는 실제 노드 수 - 1과 동일
            System.out.println(-1);
        } else {
            System.out.println(dist);
        }
    }

    static void findEdge(PriorityQueue<Edge> pq, int[] point, int[][] map) {
        int N = map.length;
        int M = map[0].length;
        int x = point[0];
        int y = point[1];
        int land = point[2];

        for(int i = 0; i<4; i++) {
            int k = 1;
            int nx,ny;
            int newLand = -1;
            while(true) {
                nx = x + k * dx[i];
                ny = y + k * dy[i];
    
                if(nx<0 || ny<0 || nx>=M || ny>=N) {
                    break;
                }
                
                if(map[ny][nx] == 0) {
                    k++;
                }else if(map[ny][nx] == land) {
                    break;
                }else {
                    newLand = map[ny][nx];
                    break;
                }
            }
            if(k-1>=2) {
                pq.add(new Edge(land, newLand, k-1));
            }
        }
    }

    static void make(int v) {
        V = v+1;
        parent = new int[V];
        for (int i = 0; i<V; i++) {
            parent[i] = -1;
        }
    }

    static int findSet(int a){
        if (a < 0 || a >= V) {
            return -1; // 유효하지 않은 인덱스 반환
        }
        if (parent[a] < 0) return a;
        return parent[a] = findSet(parent[a]);
    }
    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        // 오류 수정: 유효하지 않은 인덱스를 확인 후 작업 중지
        if (aRoot == -1 || bRoot == -1) return false;

        if (aRoot == bRoot) return false;
        parent[bRoot] = aRoot;
        return true;
    }

    static class Edge {
        int start, end, weight, distance;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}