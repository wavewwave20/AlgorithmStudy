import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] boolArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for(int tc = 1; tc<=TC; tc++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            
            if (n == 0) {
                if (p.contains("D")) {
                    answer.append("error\n");
                } else {
                    answer.append("[]\n");
                }
                continue;
            }
            
            arrStr = arrStr.substring(1, arrStr.length()-1);
            StringTokenizer st = new StringTokenizer(arrStr, ",");
            arr = new int[n];
            boolArr = new boolean[n];
            for(int i = 0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                boolArr[i] = true;
            }

            boolean asc = true;
            boolean isError = false;

            for(int i = 0; i<p.length(); i++) {
                if(p.charAt(i) == 'R') {
                    asc = funcR(asc);
                }else {//D

                    if(!funcD(asc)) {
                        isError = true;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            if(isError) {//에러처리
                sb.append("error\n");
            }else {// 정상
                sb.append("[");
                ArrayList<Integer> ansList = new ArrayList<>();
                if(asc) {
                    for(int i = 0; i<n; i++) {
                        if(boolArr[i]) {
                            ansList.add(arr[i]);
                        }
                    }
                }else {
                    for(int i = n-1; i>=0; i--) {
                        if(boolArr[i]) {
                            ansList.add(arr[i]);
                        }
                    }
                }

                for (int i = 0; i < ansList.size(); i++) {
                    sb.append(ansList.get(i));
                    if (i < ansList.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
                
            }
            answer.append(sb.toString());
        }
        System.out.println(answer.toString());
    }

    static boolean funcR(boolean asc) {
        return !asc;
    }

    static boolean funcD(boolean asc) {
        boolean flag = false; 
        if (asc) {
            for(int i = 0,size = boolArr.length; i<size; i++) {
                if(boolArr[i]) {
                    boolArr[i] = false;
                    flag = true;
                    break;
                }
            }
        }else {
            for(int i = boolArr.length-1; i>=0; i--) {
                if(boolArr[i]) {
                    boolArr[i] = false;
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}