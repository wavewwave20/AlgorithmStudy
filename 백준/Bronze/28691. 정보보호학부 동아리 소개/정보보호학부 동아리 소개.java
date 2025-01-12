import java.io.*;
import java.util.*;
public class Main {

    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        if(str.charAt(0) == 'M') {
            System.out.println("MatKor");
        }else if(str.charAt(0) == 'W') {
            System.out.println("WiCys");
        }
        else if(str.charAt(0) == 'C') {
            System.out.println("CyKor");
        }
        else if(str.charAt(0) == 'A') {
            System.out.println("AlKor");
        }
        else if(str.charAt(0) == '$') {
            System.out.println("$clear");
        }

    }
}