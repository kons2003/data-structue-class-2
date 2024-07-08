// 실수 스택 - 배열 구현
package hw;

import java.util.EmptyStackException;
import java.util.Scanner;

public class hw7_1 {
    public static void main(String[] args) {
        System.out.println("hw7_1:이길수");
        Scanner input = new Scanner(System.in);

        // (1) 실수 원소를 저장하는 용량 5인 MyArrayStack 객체 생성(stack)
        MyArrayStack stack = new MyArrayStack();

        // (2) 사용자로부터 실수 원소들을 입력받아 stack에 저장하되, 999를 입력하면 삽입하지 않고 반복을 멈춤
        double item = input.nextDouble();
        while (item != 999) {
            stack.push(item);
            item = input.nextDouble();
        }

        // (3) stack이 텅 빌때까지 하나씩 삭제하여 출력
        while (!stack.isEmpty()) {
            System.out.printf("%.1f ", stack.pop());
        }
    }
}

// MyArrayStack - 배열로 구현한 실수 스택
class MyArrayStack {
    private int top; // 스택의 꼭대기를 저장할 변수
    private double[] array;

    public MyArrayStack() { // 크기 5인 공백 스택 생성
        top = -1;
        array = new double[5];
    }

    public MyArrayStack(int capacity) { // 크기 capacity인 송백 스택 생성
        top = -1;
        array = new double[capacity];
    }

    public boolean isEmpty() { // 스택이 비었는지를 검사
        return (top == -1);
    }

    public boolean isFull() { // 스택이 가득찼는지를 검사
        return (top == array.length - 1);
    }

    public void push(double item) { // 스택에 item을 삽입
        if (isFull()) { // 스택이 가득찼을 때, 배열 용량을 2배로 늘린 후 삽입
            double[] newArray = new double[array.length * 2]; // 기존 배열 길이의 2배 크기인 배열 생성
            for (int i = 0; i < array.length; i++) { // 기존 배열 원소 복사
                newArray[i] = array[i];
            }
            array = newArray; // array 배열에 크기를 2배 늘린 newArray 배열 저장
        }
        array[++top] = item;
    }

    public double pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return array[top--];
        }
    }
}
