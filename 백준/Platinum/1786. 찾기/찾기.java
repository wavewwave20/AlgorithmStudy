import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String pattern = br.readLine();
        KMP kmp = new KMP(text, pattern);
        
        // KMP kmp = new KMP("ABABAB", "ABA");

        System.out.println(kmp.kmp());
        System.out.println(kmp.sb.toString());

        // System.out.println("=======================");
        // System.out.println(kmp.sss);
        
    }
}

class KMP {
    String pattern;
    String text;
    int[] table;
    int sss;

    StringBuilder sb;
    
    KMP(String text, String pattern) {
        this.pattern = pattern;
        this.text = text;

        table = new int[pattern.length()];
        makeTable();

        sb = new StringBuilder();
    }

    private void makeTable() {
        int n = pattern.length();
        table[0] = 0; // 첫 번째 문자에 대한 실패 함수 값은 0입니다.
        int j = 0; // 현재까지 일치한 접두사의 길이를 저장하는 변수
    
        for (int i = 1; i < n; i++) { // 패턴 문자열을 순회합니다.
            // 현재 문자와 접두사의 다음 문자가 일치하지 않을 때
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1]; // 이전에 일치했던 위치로 돌아갑니다.
            }
            // 현재 문자와 접두사의 다음 문자가 일치할 때
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++; // 일치한 길이를 증가시킵니다.
                table[i] = j; // 현재 위치의 실패 함수 값을 저장합니다.
            } else {
                table[i] = 0; // 일치하지 않으면 0을 저장합니다.
            }
        }
    }
    

    public int kmp() {
        if(pattern.length() == 1) {
            char p = pattern.charAt(0);
            int cnt = 0;
            for(int i = 0; i<text.length(); i++) {
                if(text.charAt(i) == p) {
                    cnt++;
                    sb.append(i+1 + " ");
                }
            }
            return cnt;
        }

        int j = 0;
        int i = 0;
        int cnt = 0;

        sss = 0;
        while(i<text.length()) {
            sss++;
            if(text.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;

                if(j == table.length) {
                    sb.append(i+1-pattern.length() + " ");

                    j = table[j-1];
                    cnt++;
                }
                
            }else {
                if(j != 0) {
                    j = table[j-1];
                }else {
                    i++;
                }
            }
        }
        return cnt;
    }
}
