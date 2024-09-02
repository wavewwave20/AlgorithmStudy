import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, Integer> charWeightMap = new HashMap<>();
    static List<Character> sortedChars;
    static int[] digitAssignment;
    static boolean[] usedDigits;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스가 하나라고 가정
        for (int test_case = 1; test_case <= 1; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String[] strs = new String[N];
            charWeightMap.clear();

            // 문자열 입력과 문자 가중치 계산
            for (int i = 0; i < N; i++) {
                strs[i] = br.readLine().trim();
                int len = strs[i].length();
                for (int j = 0; j < len; j++) {
                    char c = strs[i].charAt(j);
                    charWeightMap.put(c, charWeightMap.getOrDefault(c, 0) + (int) Math.pow(10, len - j - 1));
                }
            }

            // 문자 가중치에 따라 내림차순으로 정렬
            sortedChars = new ArrayList<>(charWeightMap.keySet());
            sortedChars.sort((a, b) -> charWeightMap.get(b) - charWeightMap.get(a));

            // 숫자 할당을 위한 배열 초기화
            digitAssignment = new int[10];
            usedDigits = new boolean[10];
            answer = 0;

            // 탐욕적으로 숫자를 문자에 할당
            assignDigits(0);

            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    // 숫자를 탐욕적으로 할당하는 함수
    static void assignDigits(int index) {
        if (index == sortedChars.size()) {
            // 현재 숫자 할당을 기반으로 합 계산
            int sum = calculateSum();
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 9; i >= 0; i--) {
            if (!usedDigits[i]) {
                usedDigits[i] = true;
                digitAssignment[index] = i;
                assignDigits(index + 1);
                usedDigits[i] = false;
            }
        }
    }

    // 현재 숫자 할당을 기반으로 총 합 계산
    static int calculateSum() {
        int sum = 0;
        for (Map.Entry<Character, Integer> entry : charWeightMap.entrySet()) {
            int index = sortedChars.indexOf(entry.getKey());
            sum += entry.getValue() * digitAssignment[index];
        }
        return sum;
    }
}
