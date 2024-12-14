import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static class Ball {
        int redX, redY;
        int blueX, blueY;
        int direction;
        int cnt;
        boolean blueEscape, redEscape;

    }

    static char[][]map;
    static int[] hole;
    static int X,Y;
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new char[Y][X];
        Ball init = new Ball();

        for(int y = 0; y<Y; y++) {
            String line = br.readLine();
            for(int x = 0; x<X; x++) {
                char tmp = line.charAt(x);
                if(tmp == 'R') {
                    init.redX = x;
                    init.redY = y;
                    map[y][x] = '.';
                }else if (tmp == 'B') {
                    init.blueX = x;
                    init.blueY = y;
                    map[y][x] = '.';
                }
                // else if (tmp == 'O') {
                //     hole[0] = x;
                //     hole[1] = y;
                //     map[y][x] = 'O';
                // }
                else {
                    map[y][x] = tmp; 
                }
            }
        }

        Queue<Ball> queue = new ArrayDeque<>();
        init.direction = -1;
        queue.add(init);

        int count = -1;
        while(!queue.isEmpty()) {
            Ball now = queue.poll();

            if(now.cnt > 10) {
                continue;
            }

            if(now.redEscape && !now.blueEscape) {
                count = now.cnt;
                break;
            }

            for(int i = 0; i<4; i++) {
                if(now.direction == i) {
                    continue;
                }

                Ball next = ballMoves(now, isBlueFirst(dx[i], dy[i], now), i);
                // System.out.println(next.cnt +"====================================");
                // for(int y = 0; y<Y; y++) {
                //     for(int x = 0; x<X; x++) {
                //         if(!next.blueEscape && next.blueX == x && next.blueY == y) {
                //             System.out.print('B');
                //         }else if(!next.redEscape && next.redX == x && next.redY == y) {
                //             System.out.print('R');
                //         }else {
                //             System.out.print(map[y][x]);
                //         }
                //     }
                //     System.out.println();
                // }

                if(next.blueEscape) {
                    continue;
                }
                queue.add(next);
            }
        }

        System.out.println(count);
    }

    static boolean isBlueFirst(int dx, int dy, Ball balls) {
        if(dx == 0) {
            if(dy > 0) {
                if (balls.blueY >= balls.redY) {
                    return true;
                }else {
                    return false;
                }
            }else {
                if (balls.blueY <= balls.redY) {
                    return true;
                }else {
                    return false;
                }
            }
        }else {
            if(dx > 0) {
                if (balls.blueX >= balls.redX) {
                    return true;
                }else {
                    return false;
                }
            }else {
                if (balls.blueX <= balls.redX) {
                    return true;
                }else {
                    return false;
                }
            }
        }
    }

    static Ball ballMoves(Ball balls, boolean moveBlue, int direction) {
        Ball next = new Ball();
        next.direction = direction;
        next.cnt = balls.cnt+1;

        for(int i = 0; i<2; i++) {
            int nx = balls.blueX;
            int ny = balls.blueY;
    
            if(!moveBlue) {
                nx = balls.redX;
                ny = balls.redY;
            }
            
            while(true) {
                nx += dx[direction];
                ny += dy[direction];

                if(moveBlue) {
                    if(nx == next.redX && ny == next.redY) {
                        nx -= dx[direction];
                        ny -= dy[direction];
                        break;
                    }
                }else {
                    if(nx == next.blueX && ny == next.blueY) {
                        nx -= dx[direction];
                        ny -= dy[direction];
                        break;
                    }
                }
     
                if(map[ny][nx] == '#') {
                    nx -= dx[direction];
                    ny -= dy[direction];
                    break;
                }
    
                if(map[ny][nx] == 'O') {
                    if(moveBlue) {
                        next.blueEscape = true;
                        nx = -1;
                        ny = -1;
                        break;
                    }else {
                        next.redEscape = true;
                        nx = -1;
                        ny = -1;
                        break;
                    }
                }
            }
    
            if(moveBlue) {
                next.blueX = nx;
                next.blueY = ny;
            }else {
                next.redX = nx;
                next.redY = ny;
            }

            moveBlue = !moveBlue;
        }

        return next;
    }
}