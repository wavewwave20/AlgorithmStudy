import java.io.*;
import java.util.*;

public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = n; i>0; i--) {
            for(int k = 0; k<i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}