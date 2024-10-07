import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 입력: 수열 A의 크기 N
        int N = Integer.parseInt(br.readLine());
        
        // 두 번째 줄 입력: 수열 A의 값들
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // DP 배열 생성: dp[i]는 길이가 i인 증가하는 부분 수열에서 마지막 값의 최소값
        int[] dp = new int[N];
        int length = 0;  // LIS 길이를 저장하는 변수

        // 초기 dp 배열을 큰 값으로 채우기 (상한값)
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 수열 A를 순회하면서 LIS 계산
        for (int i = 0; i < N; i++) {
            // 현재 A[i]가 들어갈 위치를 이분 탐색으로 찾음
            int pos = Arrays.binarySearch(dp, 0, length, A[i]);

            // 만약 음수 값이 반환되면 -(삽입 위치 + 1)
            if (pos < 0) {
                pos = -(pos + 1);
            }

            // dp[pos] 위치에 A[i]를 넣음 (최소값 유지)
            dp[pos] = A[i];

            // 만약 새로운 값이 배열 끝에 추가된 경우, LIS 길이를 증가
            if (pos == length) {
                length++;
            }
        }

        // 최종적으로 length가 가장 긴 증가하는 부분 수열의 길이
        System.out.println(length);
    }
}
