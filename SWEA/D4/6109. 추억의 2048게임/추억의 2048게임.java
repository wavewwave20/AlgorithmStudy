import java.util.*;
import java.io.*;

class Node {
    int v;
    boolean sum;

    Node(int v, boolean sum) {
        this.v=v;
        this.sum=sum;
    }
}

class Solution{   

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 1; test_case <= T; test_case++){  
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String type = st.nextToken();


            int[][]map = new int[N][N];
            for(int y = 0; y<N; y++) {
                st = new StringTokenizer(br.readLine());
                for(int x = 0; x<N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            if(type.equals("up")) {
                for(int x = 0; x<N; x++) {
                    Deque<Node> stack = new ArrayDeque<>();
                    for(int y = 0; y<N; y++) {
                        if(stack.size() == 0 && map[y][x] != 0) {
                            stack.offerLast(new Node(map[y][x], false));
                        }
                        else if(map[y][x] != 0){
                            if(!stack.peekLast().sum && (map[y][x] == stack.peekLast().v)) {
                                stack.pollLast();
                                stack.offerLast(new Node(map[y][x]*2, true));
                            }else {
                                stack.offerLast(new Node(map[y][x], false));
                            }
                        }

                    }

                    for(int y = 0; y<N; y++) {
                        if(stack.size() != 0) {
                            map[y][x] = stack.pollFirst().v;
                        }
                        else {
                            map[y][x] = 0;
                        }
                    }
                }
            }
            else if(type.equals("down")) {
                for(int x = 0; x<N; x++) {
                    Deque<Node> stack = new ArrayDeque<>();
                    for(int y = N-1; y>=0; y--) {
                        if(stack.size() == 0 && map[y][x] != 0) {
                            stack.offerLast(new Node(map[y][x], false));
                        }
                        else if(map[y][x] != 0){
                            if(!stack.peekLast().sum && (map[y][x] == stack.peekLast().v)) {
                                stack.pollLast();
                                stack.offerLast(new Node(map[y][x]*2, true));
                            }else {
                                stack.offerLast(new Node(map[y][x], false));
                            }
                        }

                    }

                    for(int y = N-1; y>=0; y--) {
                        if(stack.size() != 0) {
                            map[y][x] = stack.pollFirst().v;
                        }
                        else {
                            map[y][x] = 0;
                        }
                    }
                }
            }
            else if(type.equals("left")) {
                for(int y = 0; y<N; y++) {
                    Deque<Node> stack = new ArrayDeque<>();
                    for(int x = 0; x<N; x++) {
                        if(stack.size() == 0 && map[y][x] != 0) {
                            stack.offerLast(new Node(map[y][x], false));
                        }
                        else if(map[y][x] != 0){
                            if(!stack.peekLast().sum && (map[y][x] == stack.peekLast().v)) {
                                stack.pollLast();
                                stack.offerLast(new Node(map[y][x]*2, true));
                            }else {
                                stack.offerLast(new Node(map[y][x], false));
                            }
                        }

                    }

                    for(int x = 0; x<N; x++) {
                        if(stack.size() != 0) {
                            map[y][x] = stack.pollFirst().v;
                        }
                        else {
                            map[y][x] = 0;
                        }
                    }
                }
            }
            else if(type.equals("right")) {
                for(int y = 0; y<N; y++) {
                    Deque<Node> stack = new ArrayDeque<>();
                    for(int x = N-1; x>=0; x--) {
                        if(stack.size() == 0 && map[y][x] != 0) {
                            stack.offerLast(new Node(map[y][x], false));
                        }
                        else if(map[y][x] != 0){
                            if(!stack.peekLast().sum && (map[y][x] == stack.peekLast().v)) {
                                stack.pollLast();
                                stack.offerLast(new Node(map[y][x]*2, true));
                            }else {
                                stack.offerLast(new Node(map[y][x], false));
                            }
                        }

                    }

                    for(int x = N-1; x>=0; x--) {
                        if(stack.size() != 0) {
                            map[y][x] = stack.pollFirst().v;
                        }
                        else {
                            map[y][x] = 0;
                        }
                    }
                }
            }

            

            sb.append("#" + test_case).append("\n");
            for(int y = 0; y<N; y++) {
                for(int x = 0; x<N; x++) {
                    sb.append(map[y][x] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }

}