import java.io.*;
import java.util.*;

public class Main {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String a = br.readLine();
        String b = br.readLine();

        if(a.length()<b.length()) {
            System.out.println("no");
        }else {
            System.out.println("go");
        }
    }
        
}