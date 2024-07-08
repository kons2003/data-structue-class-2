// 정수 원형큐
package lab;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class lab10_2 {
    public static void main(String[] args) {
        System.out.println("lab10_2:이길수");
        Scanner input = new Scanner(System.in);

        //  (1) 사용자로부터 정수 n을 입력받아 용량이 n인 원형큐를 생성(queue)
        int n = input.nextInt();
        MyQueue queue = new MyQueue(n);

        //  (2) queue에 0, 1, 2, 3, ..., n-1을 삽입
        for (int i = 0; i < n; i++) {
            queue.enQueue(i);
        }

        //  (3) queue가 텅 빌때까지 queue에서 삭제하여 삭제한 정수가 짝수인 경우에만 출력
        while (!queue.isEmpty()) {
            int x = queue.deQueue();
            if (x % 2 == 0) {
                System.out.print(x + " ");
            }
        }
        System.out.println();
    }
}

class MyQueue {
    private int[] queue;
    private int size;
    private int front = 0;
    private int rear = 0;
    private int counter = 0;

    public MyQueue(int n) {
        size = n;
        queue = new int[n];
    }

    public boolean isFull() {
        return counter == size;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public void enQueue(int item) {
        if (isFull()) {
            System.out.println("queue full error");
        } else {
            counter++;
            rear = (rear + 1) % size;
            queue[rear] = item;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            counter--;
            front = (front + 1) % size;
            return queue[front];
        }
    }
}