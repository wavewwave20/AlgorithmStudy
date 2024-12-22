import java.io.*;
import java.util.*;

public class Main {
    static long DIVIDER = 1_000_000_007;
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fibonacci(n));
    }

    static Matrix multi(Matrix A, Matrix B) {
        Matrix result = new Matrix();
        result.data[0][0] = ((A.data[0][0] * B.data[0][0]) % DIVIDER
             + (A.data[0][1] * B.data[1][0]) % DIVIDER) % DIVIDER;
        result.data[0][1] = ((A.data[0][0] * B.data[0][1]) % DIVIDER + (A.data[0][1] * B.data[1][1]) % DIVIDER) % DIVIDER;
        result.data[1][0] = ((A.data[1][0] * B.data[0][0]) % DIVIDER + (A.data[1][1] * B.data[1][0]) % DIVIDER) % DIVIDER;
        result.data[1][1] = ((A.data[1][0] * B.data[0][1]) % DIVIDER + (A.data[1][1] * B.data[1][1]) % DIVIDER) % DIVIDER;

        return result;
    }

    static Matrix pow(Matrix A, long n) {
        if(n>1) {
            A = pow(A, n/2);
            A = multi(A, A);

            if(n%2 == 1) {
                Matrix B = new Matrix();
                A = multi(A, B);
            }
        }
        return A;
    }

    static long fibonacci(long n) {
        if(n==0) {
            return 0;
        }
        Matrix A = new Matrix();
        A = pow(A, n);
        return A.data[0][1];
    }

    static class Matrix {
        long [][]data;

        Matrix() {
            data = new long[2][2];
            data[0][0] = 0;
            data[0][1] = 1;
            data[1][0] = 1;
            data[1][1] = 1;
        }
    }
        
}