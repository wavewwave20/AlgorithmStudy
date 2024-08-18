import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int windowSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
           
        Deque<Node> deque = new LinkedList<>();

        for(int i = 0; i<n; i++) {
            Node now = new Node(i, Integer.parseInt(st.nextToken()));

            while(!deque.isEmpty() && deque.getLast().value > now.value) {
                deque.removeLast();
            }
            deque.addLast(now);
            
            if (i - deque.getFirst().index + 1 > windowSize) {
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value + " ");

        }
        bw.flush();
        bw.close();

    }

    public static class Node {
        public int index;
        public int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
