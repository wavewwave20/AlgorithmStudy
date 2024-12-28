import java.io.*;
import java.util.*;

public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(name.equals("#") && age == 0 && weight == 0) {
                break;
            }

            System.out.print(name + " ");
            if(age > 17 || weight >= 80) {
                System.out.println("Senior");
            }else {
                System.out.println("Junior");
            }
        }
    }
}