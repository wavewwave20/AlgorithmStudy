import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] boolArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=9; i++) {
            sb.append(n + " * " + i + " = " + n*i+ "\n");
        }


        System.out.println(sb.toString());
    }
}