import java.util.*;
import java.io.*;

class Main {
    static class Room {
        int start, end;
        Room(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        
        List<Room> rooms = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rooms.add(new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(rooms, (o1, o2) -> {
            if (o1.end == o2.end) {
                return Integer.compare(o1.start, o2.start);
            }
            return Integer.compare(o1.end, o2.end);
        });

        int end = 0;
        int cnt = 0;
        for(int i = 0; i<n; i++) {
            if(rooms.get(i).start >= end) {
                cnt++;
                end = rooms.get(i).end;              
            }
        }

        System.out.print(cnt);
	}
}
