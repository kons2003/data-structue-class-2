// 삽입 정렬
package hw;

import java.util.Scanner;

public class hw11_1 {
    public static void main(String[] args) {
        System.out.println("hw11_1:이길수");
        Scanner input = new Scanner(System.in);

        // (1) 사용자가 원하는 갯수의 단어를 입력받아 문자열 배열에 저장
        int n = input.nextInt(); // 단어의 개수

        String[] words = new String[n]; // 단어 배열
        for (int i = 0; i < n; i++) {
            words[i] = input.next(); // 단어 입력
        }

        // (2) 배열을 삽입 정렬
        insertionSort(words);

        //  (3) 배열 원소들을 모두 출력
        for (String s : words) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    // 문자열 배열을 매개변수로 받아서 단어의 길이 기준 삽입 정렬 메소드
    static void insertionSort(String[] words) {
        for (int i = 1; i < words.length; i++) {
            String item = words[i]; // 정렬할 단어 저장
            int itemLength = item.length(); // 정렬할 단어의 길이 저장
            int j; // item이 삽입될 위치
            for (j = i; (j > 0) && (words[j - 1].length() > itemLength); j--) { // j는 최소 0까지 가능(배열 범위 안 벗어남), 정렬할 단어 길이가 더 작을떄(같은 길이는 x)반복
                words[j] = words[j - 1]; // 정렬할 단어 한 칸 앞으로 이동
            }
            words[j] = item; // 정렬된 위치에 삽입
        }
    }
}
