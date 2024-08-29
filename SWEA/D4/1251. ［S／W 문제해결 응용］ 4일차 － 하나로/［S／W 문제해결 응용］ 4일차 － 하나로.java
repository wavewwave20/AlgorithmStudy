import java.util.*;

import org.w3c.dom.Node;

import java.io.*;

class Solution
{   
    static int [] parent;
    static int N;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Integer.parseInt(br.readLine());
            int [][] island = new int[N][2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++) {
                island[i][0] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++) {
                island[i][1] = Integer.parseInt(st.nextToken());
            }


            double E = Double.parseDouble(br.readLine());
            
            List<Edge> edges = new ArrayList<>();

            for(int i = 0; i<N; i++) {
                for(int j = i+1; j<N; j++) {
                    double v = E * (Math.pow(island[i][0]-island[j][0],2) + Math.pow(island[i][1]-island[j][1],2));
                    edges.add(new Edge(i, j, v));
                }
            }
            
            Collections.sort(edges);
            
            make();

            double cost = 0;
            int cnt = 0;
            for(Edge edge : edges) {
                if(union(edge.from, edge.to)) {
                    cost += edge.value;
                    if(++cnt == N-1 ) break;
                }
            }
            
            sb.append("#" + test_case + " ").append(Math.round(cost)).append("\n");
		}
        System.out.println(sb.toString());
	}

    static void make() {
        parent = new int[N];
        Arrays.fill(parent, -1);
    }

    static int findSet(int a) {
        if(parent[a] <0) return a;
        return parent[a] = findSet(parent[a]);
    }
    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) {
            return false;
        }
        parent[bRoot] = aRoot;
        return true;
    }

    static class Edge implements Comparable<Edge>{
        int from,to;
        double value;

        public Edge(int from, int to, double value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Solution.Edge o) {
            return Double.compare(this.value, o.value);
        }
    }
}