package lab;// 자바복습1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lab0_1 {
    public static void main(String[] args) throws IOException {
        System.out.println("lab0_1:이길수");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE; // 최대값 저장 변수

        // arr 배열에 정수 입력 코드
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) { // 최대값 계산
                max = arr[i];
            }
        }

        // 최대값 제외, 배열값 출력 코드
        for (int i = 0; i < n; i++) {
            if (arr[i] < max) { // 최대값이면 출력 안 함
                System.out.printf("%d ", arr[i]);
            }
        }
        System.out.println(); // 줄바꿈
    }
}
