import java.util.*;
import java.io.*;

class Solution
{   
    static int [] dx = {0,0,1,0,-1};
    static int [] dy = {0,-1,0,1,0};
    static int M, A;
    static int[] moveA, moveB;
    static List<Ap> apInfo, chargeA, chargeB;
    static int aX, aY, bX, bY;

    static class Ap {
        int idx;
        int x;
        int y;
        int c;
        int p;
        public Ap(int idx, int x, int y, int c, int p) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
        @Override
        public String toString() {
            return "Ap [idx=" + idx + ", x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + "]";
        }
    }

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            moveA = new int[M];
            moveB = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }
            
            apInfo = new ArrayList<>();
            chargeA = new ArrayList<>();
            chargeB = new ArrayList<>();

            for(int i = 0; i<A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) -1;
                int y = Integer.parseInt(st.nextToken()) -1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                apInfo.add(new Ap(
                    i, 
                    x, 
                    y, 
                    c, 
                    p
                ));
            }
            aX = 0;
            aY = 0;
            bX = 9;
            bY = 9;

            //a의 ap리스트 초기 위치 추가
            //b의 ap리스트 초기 위치 추가
            updateChargeList();
            int sum = 0;
            for(int time = 0; time<=M; time++) {
                int prevSum = sum;
                //충전 가능 확인
                if(chargeA.size() != 0 && chargeB.size() != 0) {
                    if(chargeA.get(0).idx == chargeB.get(0).idx) {
                        //가장 큰 ap가 서로 같음
                        //1.나눠 충전
                        int a = chargeA.get(0).p;
                        
                        
                        //2. a가 양보
                        if(chargeA.size() >=2) {
                            int b = chargeA.get(1).p + chargeB.get(0).p;
                            if(a < b) {
                                a = b;
                            }
                        }

                        //2. b가 양보
                        if(chargeB.size() >=2) {
                            int c = chargeB.get(1).p + chargeA.get(0).p;
                            if(a < c) {
                                a = c;
                            }
                        }

                        sum += a;
                    }else {
                        //가장 큰 ap가 서로 다름
                        sum += chargeA.get(0).p;
                        sum += chargeB.get(0).p;
                    }

                }else {
                    //한쪽만 충전 가능한 경우
                    if(chargeA.size() != 0) {
                        sum += chargeA.get(0).p;
                    }else if(chargeB.size() != 0){
                        sum += chargeB.get(0).p;
                    }
                }

                // System.out.println(sum - prevSum);

                if(time != M) {
                    aX += dx[moveA[time]];
                    aY += dy[moveA[time]];
                    bX += dx[moveB[time]];
                    bY += dy[moveB[time]];
    
                    updateChargeList();
                }

                
            }

            sb.append("#" + test_case + " " + sum + "\n");
		}
        System.out.println(sb.toString());
	}

    static int getDistance(int x1, int y1, int x2, int y2) {
        // System.out.println((int)Math.abs(x1-x2) + (int)Math.abs(y1-y2));
        return (int)Math.abs(x1-x2) + (int)Math.abs(y1-y2);
    }


    static void updateChargeList() {
        chargeA = new ArrayList<>();
        chargeB = new ArrayList<>();
        
        for(Ap ap : apInfo) {
            //a 확인
            if(getDistance(ap.x, ap.y, aX, aY) <= ap.c) {
                chargeA.add(ap);
            }
            //b 확인
            if(getDistance(ap.x, ap.y, bX, bY) <= ap.c) {
                chargeB.add(ap);
            }
        }

        Comparator c = new Comparator<Ap>() {
            @Override
            public int compare(Ap o1, Ap o2) {
                return (Integer.compare(o2.p, o1.p));
            }
        };

        //내림차순 정렬
        Collections.sort(chargeA, c);
        Collections.sort(chargeB, c);
        // System.out.println(chargeA.toString());
        // System.out.println(chargeB.toString());
        // System.out.println();
    }
}