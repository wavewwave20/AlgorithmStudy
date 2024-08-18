import java.io.*;
import java.util.*;

public class Main{
    static int n, fullStat, answer = Integer.MAX_VALUE;
    static int[]people;
    static List<Integer>[] list;
    static Set<Integer>set = new HashSet<>();
    static boolean[]check;

    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList[n+1];
		people = new int[n+1];
        //연결 맵의 0번 인덱스는 인구수
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<>();
			people[i] = Integer.parseInt(st.nextToken());
		}
		//1번인덱스부터 연결된 노드 표시
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			int jl = Integer.parseInt(st.nextToken());
			for(int j=0; j<jl; j++) {
				int b = Integer.parseInt(st.nextToken());
				list[i].add(b);
			}
		}
        //도시를 표시하기위한 비트 도시가 3개일경우 10000 -1 -> 01111
        fullStat = (1<<n+1) -1;
        //i는 선택할 도시의 갯수 nC1, nC2, nC3...
        for(int i = 0; i<n-1; i++) {
            int stat = 1<<1; // 10 1번도시가 선택된 상태
            dfs(1,people[1],i,stat);
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs(int idx, int cost, int r, int stat) {
        //기저조건 r=0 모든 도시에 대해 dfs완료
        if(r == 0) {
            // set으로 선택도시 중복체크
            if(set.add(stat)) {
                //연결테스트, 인구수 체크 호출
                getDiff(stat);
            }
            return;
        }
        for(int i = idx; i<n; i++) {
            // or 연산 도시 선택
            stat |= 1<<(i+1);
            dfs(i+1, cost+people[i+1], r-1, stat);
            // xor 연산 도시 선택 해제
            stat ^= 1<<(i+1);
        }
    }

    //ㅇ
    static void getDiff(int stat) {
        //선택된 도시와 나머지 도시 표시
        int a = stat;
        int b = fullStat^(a);

        int aCost, bCost;
        if((aCost=linkTesting(a)) != -1 & (bCost=linkTesting(b)) != -1) {
            answer = Math.min(answer, Math.abs(aCost-bCost));
        }
    }

    // bfs 선택된 도시들이 연결되어있는지 확인
    static int linkTesting(int stat) {
        List<Integer> city = new ArrayList<>();
        for(int i = 1; i<n+1; i++) {
            // stat의 i번째가 선택 되어 있다면?
            // and연산으로 i번째 값만 선택하기
            if((stat & (1<<i)) == 1<<i) {
                city.add(i);
            }
        }

        check = new boolean[n+1];
        int st = city.get(0);
        check[st] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        int cost = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            cost += people[cur];
            for(int nxt : list[cur]) {
                if(!check[nxt] && city.contains(nxt)) {
                    check[nxt] = true;
                    q.add(nxt);
                }
            }
        }

        //리스트의 city중 방문하지 않은 곳이 있는지 확인
        for(int i : city) {
            if(!check[i]) {
                return -1;
            }
        }
        return cost;
    }
} 