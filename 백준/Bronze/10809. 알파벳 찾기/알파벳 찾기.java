import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for(int i = 'a'; i<='z'; i++) {
            System.out.print(str.indexOf(i) + " ");
        }
        
    }
}