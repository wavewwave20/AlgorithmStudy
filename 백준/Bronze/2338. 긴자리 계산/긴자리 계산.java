import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal a = new BigDecimal(br.readLine());
        BigDecimal b = new BigDecimal(br.readLine());
        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
    }
}