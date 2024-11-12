import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, char[]> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        tree = new HashMap<>();
        
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char mid = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.put(mid, new char[]{mid, left,right});
        }

        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');
    }

    static void preOrder(char mid) {
        System.out.print(mid);
        char[] next = tree.get(mid);
        if(next[1] != '.') {
            preOrder(next[1]);
        }
        if(next[2] != '.') {
            preOrder(next[2]);
        }
    }

    static void inOrder(char mid) {
        
        char[] next = tree.get(mid);
        if(next[1] != '.') {
            inOrder(next[1]);
        }
        System.out.print(mid);
        if(next[2] != '.') {
            inOrder(next[2]);
        }
    }

    static void postOrder(char mid) {
        char[] next = tree.get(mid);
        if(next[1] != '.') {
            postOrder(next[1]);
        }
        if(next[2] != '.') {
            postOrder(next[2]);
        }
        System.out.print(mid);
    }



}