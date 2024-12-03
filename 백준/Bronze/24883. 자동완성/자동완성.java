import java.io.*;
import java.util.*;

public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        if(str.equals("n") || str.equals("N")) {
            System.out.println("Naver D2");
        }else {
            System.out.println("Naver Whale");
        }
    }
}