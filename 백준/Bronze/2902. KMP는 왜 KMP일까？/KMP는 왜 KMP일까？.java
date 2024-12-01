import java.io.*;
import java.util.*;

public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        sb.append(str.charAt(0));
        for(int i = 1; i<str.length(); i++) {
            if(str.charAt(i) == '-') {
                sb.append(str.charAt(i+1));
            }
        }
        System.out.println(sb);
    }
}