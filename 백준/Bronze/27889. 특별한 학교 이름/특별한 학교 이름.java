import java.io.*;
import java.util.*;

public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if(str.equals("NLCS")) {
            System.out.println("North London Collegiate School");
        }else if(str.equals("BHA")) {
            System.out.println("Branksome Hall Asia");
        }else if(str.equals("KIS")) {
            System.out.println("Korea International School");
        }else if(str.equals("SJA")) {
            System.out.println("St. Johnsbury Academy");
        }
    }
}