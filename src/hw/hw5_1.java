package hw;// 리스트 삽입/삭제

public class hw5_1 {
    public static void main(String[] args) {
        System.out.println("hw.hw5_1:이길수");

        // (1) MyArrayList형 리스트 객체 list를 생성
        MyArrayList list = new MyArrayList();

        // (2) list에 10, 20, 30, 40을 차례대로 삽입
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // (3) list 내용을 출력
        System.out.println(list);      // list.toString()이 호출됨

        // (4) list에서 50, 20, 40, 10, 30의 위치(인덱스)를 알아내어 출력(indexOf 호출)
        System.out.print(list.indexOf(50) + " ");
        System.out.print(list.indexOf(20) + " ");
        System.out.print(list.indexOf(40) + " ");
        System.out.print(list.indexOf(10) + " ");
        System.out.print(list.indexOf(30) + " ");
        System.out.println(); // 줄바꿈

        //  (5) list에서 50, 20, 40, 10, 30, 30 순서로 삭제
        list.remove(50);
        list.remove(20);
        list.remove(40);
        list.remove(10);
        list.remove(30);
        list.remove(30);

        //  (6) list 내용을 출력
        System.out.println(list);

        // (7) list의 맨 앞에 10, 20, 30, 40을 차례대로 삽입
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);

        // (8) list 내용을 출력
        System.out.println(list);
    }
}

// 정수 리스트를 배열로 구현하는 클래스
class MyArrayList {
    private int[] array;// 원소를 저장할 배열
    private int size;// 배열에 저장된 원소 수(리스트 길이)
    private static final int DEFAULT_CAPACITY = 10;// 배열의 기본 용량

    public MyArrayList() {// 생성자 1 : 배열 용량을 기본값으로 함
        array = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int capacity) {// 생성자 2 : 배열 용량을 매개변수로 받음
        array = new int[capacity];
        size = 0;
    }

    public void add(int item) {// 리스트의 맨 뒤에 item 삽입
        if (size >= array.length) {
            System.out.println("배열이 가득차서 삽입 실패했습니다.");  // 에러 처리
        } else {
            array[size++] = item;
        }
    }

    public int indexOf(int item) { // 정수 원소를 매개변수로 받아 그 원소의 리스트상 위치(인덱스)를 리턴. 없는 원소이면 -1 리턴
        for (int i = 0; i < size; i++) {
            if (item == array[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {  // 리스트의 내용을 하나의 문자열로 만들어 리턴 - ArrayList와 구분하기 위해 [] 대신에 ()를 사용할 것
        if (size == 0) return "()";
        StringBuffer result = new StringBuffer("(");
        for (int i = 0; i < size - 1; i++) {
            result.append(array[i] + ", ");
        }
        result.append(array[size - 1] + ")");
        return result.toString();
    }

    public void remove(int item) { // 매개변수로 받은 원소를 리스트에서 제거 후, 원소들을 한 칸씩 앞으로 이동하고 size 축소, 없는 원소이면 실행 안 함
        int index = indexOf(item);
        if (index != -1) { // 존재하는 원소일 때만 수행
            for (int i = index; i < size-1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    public void addFirst(int item) { // 정수 원소를 매개변수로 받아 리스트의 맨 앞에 삽입, 원소를 저장할 배열 크기보다 리스트 크기가 커지면 에러 처리
        if (size >= array.length) {
            System.out.println("배열이 가득차서 삽입 실패했습니다.");  // 에러 처리
        } else {
            size++;
            for (int i = size-1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = item;
        }
    }
}
