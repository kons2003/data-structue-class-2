// 문자열 배열
package lab;

import java.util.Scanner;

public class lab11_1 {
    public static void main(String[] args) {
        System.out.println("lab11_1:이길수");
        Scanner input = new Scanner(System.in);

        // (1) 사용자가 원하는 갯수의 단어를 입력받아 문자열 배열에 저장
        int n = input.nextInt(); // 단어의 개수

        String[] words = new String[n]; // 단어 배열
        for (int i = 0; i < n; i++) {
            words[i] = input.next(); // 단어 입력
        }

        //  (2) 배열 원소들을 모두 출력
        for (String s : words) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
