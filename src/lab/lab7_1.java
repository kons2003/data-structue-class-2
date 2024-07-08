package lab;// 정수 스택 - 단순연결리스트 구현

import java.util.EmptyStackException;
import java.util.Scanner;

public class lab7_1 {
    public static void main(String[] args) {
        System.out.println("lab7_1:이길수");
        Scanner input = new Scanner(System.in);

        // (1) 정수 원소를 저장하는 MyLinkedStack 객체 생성(stack)
        MyLinkedStack stack = new MyLinkedStack();

        // (2) 사용자로부터 정수 원소들을 입력받아 stack에 저장하되, 999를 입력하면 삽입하지 않고 반복을 멈춤
        int item = input.nextInt();
        while (item != 999) {
            stack.push(item);
            item = input.nextInt();
        }

        // (3) stack이 텅 빌때까지 하나씩 삭제하여 출력
        while (!stack.isEmpty()) {
            System.out.printf("%d ", stack.pop());
        }
    }
}

// 단순 연결리스트로 구현한 정수 스택
class MyLinkedStack {
    // 노드 구조
    private class Node {
        int data;
        Node link;
    }

    // 꼭대기 노드를 가리키는 인스턴스 변수
    private Node top = null;

    // 스택이 비었는지를 검사하는 메소드
    public boolean isEmpty() {
        return (top == null);
    }

    // 스택에 원소를 삽입하는 메소드
    public void push(int item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.link = top;
        top = newNode;
    }

    // 스택의 꼭대기 원소를 삭제하여 리턴하는 메소드
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            int item = top.data;
            top = top.link;
            return item;
        }
    }
}