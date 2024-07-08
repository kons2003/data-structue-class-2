package hw;// 단순연결리스트 삽입/삭제

public class hw6_1 {
    public static void main(String[] args) {
        System.out.println("hw.hw6_1:이길수");

        // (1) MyLinkedList형 리스트 객체 list를 생성
        MyLinkedList list = new MyLinkedList();

        // (2) list의 맨 뒤에 10, 30, 20, 30, 40을 차례대로 모두 삽입한 후 list 내용을 출력
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(list);

        // (3) list에서 30, 20, 50, 40, 10, 30, 60을 차례대로 삭제하고 각 원소 삭제 후 매번 리스트 내용을 출력
        list.remove(30);
        System.out.println(list);
        list.remove(20);
        System.out.println(list);
        list.remove(50);
        System.out.println(list);
        list.remove(40);
        System.out.println(list);
        list.remove(10);
        System.out.println(list);
        list.remove(30);
        System.out.println(list);
        list.remove(60);
        System.out.println(list);
    }
}

// 정수 리스트를 단순연결리스트로 구현한 클래스
class MyLinkedList {
    private Node head; 		// 리스트의 첫번째 노드를 가리키는 변수
    private int size;          // 리스트 길이(원소 수)

    // 연결 리스트 노드 구조
    private class Node {
        int data;
        Node link;
    }

    // 공백 리스트를 생성
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // 리스트의 맨 앞에 data를 삽입
    public void addFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.link = head;
        head = newNode;
        size++;
    }

    // 리스트의 원소 존재 여부 확인
    public boolean contains(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.link;
        }
        return false;
    }

    // 리스트 원소들을 하나의 문자열로 만들어 리턴
    @Override
    public String toString() {  // LinkedList와 구분하기 위해 [] 대신에 ()를 사용할 것
        StringBuffer result = new StringBuffer("(");
        Node temp = head;
        if(size > 0) {
            for(int i = 0; i < size - 1; i++) {
                result.append(temp.data + ", ");
                temp = temp.link;
            }
            result.append(temp.data);
        }
        result.append(")");
        return result.toString();
    }

    // 정수 원소를 매개변수로 받아 리스트의 맨 뒤에 삽입
    public void add(int data) {
        Node newNode = new Node();
        newNode.data = data; // 매개변수로 받은 정수를 newNode에 저장
        if (head == null) { // 빈 리스트면 첫 원소에 삽입
            head = newNode;
        } else {
            Node temp = head;
            while (temp.link != null) { // 마지막 원소까지 temp 이동
                temp = temp.link;
            }
            temp.link = newNode; // 마지막 원소에 매개변수 삽입
        }
        size++; // 리스트 길이 증가
    }

    // 정수 원소를 매개변수로 받아 그 원소를 리스트에서 삭제
    public void remove(int data) {
        if (head == null) { // 공백 리스트인 경우 삭제 안 함
            return;
        } else if (head.data == data) { // 첫 원소가 매개변수인 경우
            head = head.link;
            size--;
        } else { // 리스트 원소가 둘 이상인 경우
            Node newNode = head;
            Node temp = head.link;
            while (temp != null) { // 원소가 null이 아닐때까지 반복
                if (temp.data == data) { // temp.data가 매개변수인 경우
                    newNode.link = temp.link; // 매개변수와 같은 값의 원소를 건너뜀
                    size--; // 리스트 길이 감소
                    break; // 동일한 원소가 여러개면 가장 앞에 있는 하나만 삭제하기 위해 while문 break
                }
                newNode = temp; // 다음 원소 가리킴
                temp = temp.link; // 다음 원소 가리킴
            }
        }
    }
}