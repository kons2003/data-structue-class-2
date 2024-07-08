package lab;// 자바복습2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 두가지 점수 정보를 관리하는 MyScore 클래스
class MyScore {
    // 1회차, 2회차 점수를 나타내는 인스턴스 변수
    private int exam1, exam2;

    // 1회차, 2회차 점수를 매개변수로 받아 초기화하는 생성자
    public MyScore(int exam1, int exam2) {
        this.exam1 = exam1;
        this.exam2 = exam2;
    }

    // 반영 비율을 1회차 점수는 40%, 2회차 점수는 60%로 하여 최종 점수를 계산하여 리턴하는 메소드
    public double getFinalScore() {
        return (exam1 - exam1 * 0.6) + (exam2 - exam2 * 0.4);
    }

    // toString 오버라이드 - 이 객체에 저장된 정보(1회차, 2회차 점수)를 하나의 문자열로 만들어 리턴
    @Override
    public String toString() {
        return "(" + exam1 + ", " + exam2 + ")";
    }
}

public class lab0_2 {
    public static void main(String[] args) throws IOException {
        System.out.println("lab0_2:이길수");

        // 사용자로부터 1회차, 2회차 점수를 입력받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int exam1 = Integer.parseInt(st.nextToken());
        int exam2 = Integer.parseInt(st.nextToken());

        // 입력받은 두 값을 초기값으로 하는 MyScore 객체 생성(score)
        MyScore score = new MyScore(exam1, exam2);

        // 내부적인 반영 비율로 계산한 score의 최종 점수를 알아내어 출력
        System.out.println(score.getFinalScore());

        // score에 저장된 정보를 출력(toString 호출하여 출력)
        System.out.println(score); // System.out.println(score.toString());
    }
}

