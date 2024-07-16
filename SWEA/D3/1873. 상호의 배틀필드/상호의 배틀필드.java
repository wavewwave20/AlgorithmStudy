import java.util.*;
import java.io.*;

class Solution
{   
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    static char [][] map;
    static int X;
    static int Y;
    static int [] tankPosition;
    static int tankDirection;

    public static boolean canMove(int[] tankPosition, int dir, char[][] map) {
        int nx = tankPosition[0] + dx[dir];
        int ny = tankPosition[1] + dy[dir];

        if(nx<0 || ny<0 || nx>=X || ny>=Y) {
            return false;
        }
        if(map[ny][nx] != '.') {
            return false;
        }
        return true;
    }

    public static void shoot(int[] tankPosition, int tankDirection, char[][] map) {
        int x = tankPosition[0];
        int y = tankPosition[1];
        
        while(true) {
            int nx = x + dx[tankDirection];
            int ny = y + dy[tankDirection];

            if(nx<0 || ny<0 || nx>=X || ny>=Y) {
                break;
            }

            if(map[ny][nx] == '#') {
                break;
            }

            if(map[ny][nx] == '*') {
                map[ny][nx] = '.';
                break;
            }

            x = nx;
            y = ny;
        }  
    }

    public static void move(int[] tankPosition, int dir, char[][] map) {
        int x = tankPosition[0];
        int y = tankPosition[1];
        char[] tankView = {'^', 'v', '<', '>'};

        if(canMove(tankPosition, dir, map)) {
            map[y+dy[dir]][x+dx[dir]] = tankView[dir];
            map[y][x] = '.';
            tankDirection = dir;
            tankPosition[0] = x+dx[dir];
            tankPosition[1] = y+dy[dir];
        }else {
            map[y][x] = tankView[dir];
            tankDirection = dir;
        }
    }

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());

            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            map = new char[Y][X];

            tankPosition = new int[2]; // x y
            tankDirection = 0;//위0 아래1 왼2 오3

            for(int y = 0; y<Y; y++) {
                String str = br.readLine();
                for(int x = 0; x<X; x++) {
                    map[y][x] = str.charAt(x);
                    if(str.charAt(x) == '^') {
                        tankPosition[0] = x;
                        tankPosition[1] = y;
                        tankDirection = 0;
                    }
                    if(str.charAt(x) == 'v') {
                        tankPosition[0] = x;
                        tankPosition[1] = y;
                        tankDirection = 1;
                    }
                    if(str.charAt(x) == '<') {
                        tankPosition[0] = x;
                        tankPosition[1] = y;
                        tankDirection = 2;
                    }
                    if(str.charAt(x) == '>') {
                        tankPosition[0] = x;
                        tankPosition[1] = y;
                        tankDirection = 3;
                    }
                }
            }

            br.readLine();
            char [] commands = br.readLine().toCharArray();

            for(char command : commands) {
                if(command == 'U') {
                    move(tankPosition, 0, map);
                }
                else if (command == 'D') {
                    move(tankPosition, 1, map);
                }
                else if (command == 'L') {
                    move(tankPosition, 2, map);
                }
                else if (command == 'R') {
                    move(tankPosition, 3, map);
                }
                else if (command == 'S') {
                    shoot(tankPosition, tankDirection, map);
                }
            }

            System.out.print("#" + test_case + " ");
            for(int y = 0; y<Y; y++) {
                for(int x = 0; x<X; x++) {
                    System.out.print(map[y][x]);
                }
                System.out.println();
            }
		}
	}
}