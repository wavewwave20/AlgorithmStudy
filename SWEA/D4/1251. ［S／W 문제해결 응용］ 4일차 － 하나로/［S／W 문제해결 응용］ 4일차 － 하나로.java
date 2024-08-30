import java.util.*;
import java.io.*;

class Solution
{   
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
            

            double[][] edgeMatrix = new double[N][N];

            for(int i = 0; i<N; i++) {
                for(int j = i+1; j<N; j++) {
                    double v = E * (Math.pow(island[i][0]-island[j][0],2) + Math.pow(island[i][1]-island[j][1],2));
                    edgeMatrix[i][j] = (v);
                    edgeMatrix[j][i] = (v);
                }
            }
            
            double[]minEdge = new double[N];
            boolean[] visited = new boolean[N];
            Arrays.fill(minEdge, Double.MAX_VALUE);
            minEdge[0] = 0;
            double cost = 0;

            int i = 0;
            for(i = 0; i<N; i++) {
                double min = Double.MAX_VALUE;
                int minVertex = -1;

                for(int j = 0; j<N; j++) {
                    if(visited[j])continue;
                    if(min > minEdge[j]) {
                        minVertex = j;
                        min = minEdge[j];
                    }
                }

                if(minVertex == -1) break;
                visited[minVertex] = true;
                cost += min;

                for(int j = 0; j<N; j++) {
                    if(!visited[j] && edgeMatrix[minVertex][j] != 0 && minEdge[j] > edgeMatrix[minVertex][j]) {
                        minEdge[j] = edgeMatrix[minVertex][j];
                    }
                }
            }  
            
            sb.append("#" + test_case + " ").append(Math.round(cost)).append("\n");
		}
        System.out.println(sb.toString());
	}
}