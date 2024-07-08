// binary search tree 검색/합
package hw;

import java.util.Scanner;

public class hw9_1 {
    public static void main(String[] args) {
        System.out.println("hw9_1:이길수");

        // (1) 공백 이진탐색트리인 MyBinarySearchTree 객체 생성(tree)
        MyBinarySearchTree tree = new MyBinarySearchTree();

        // (2) 키값 개수(n)와 n개의 정수 키값을 입력받아 tree에 삽입
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int key = input.nextInt(); // key를 입력받음
            tree.insert(key); // key를 tree에 삽입
        }

        // (3) tree를 inorder traversal
        tree.inorder();

        // (4) tree의 키값 합을 구하여 출력 ** 주의: 단계(2)에서 입력받은 키값을 더하면 안되고, 트리에게 물어보아 합을 얻어야 함
        System.out.println(tree.sum());

        // (5) 키값 개수(m)와 m개의 정수 키값을 입력받아 tree에서 검색하여 결과 출력
        int m = input.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.print(tree.contains(input.nextInt()) + " ");
        }
        System.out.println();

        input.close();
    }
}

// 정수 키값을 갖는 binary search tree를 연결자료구조로 구현한 클래스
class MyBinarySearchTree {
    // 루트 노드를 가리키는 인스턴스 변수
    private Node root = null;

    // 노드 구조를 정의하는 클래스
    private class Node {
        int key;
        Node leftChild = null;
        Node rightChild = null;
    }

    // 트리에 key를 삽입
    public void insert(int key) {
        root = insertKey(root, key);
    }

    // p를 루트로 하는 트리에 key를 삽입한 후, 루트 노드를 리턴(재귀 알고리즘)
    private Node insertKey(Node p, int key) {
        if (p == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.leftChild = null;
            newNode.rightChild = null;
            return newNode;
        } else if (key < p.key) {
            p.leftChild = insertKey(p.leftChild, key);
            return p;
        } else if (key > p.key) {
            p.rightChild = insertKey(p.rightChild, key);
            return p;
        }
        return p;
    }

    // 트리를 inorder traversal
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    // p를 루트로 하는 트리를 inorder traversal하여 키값을 출력(재귀 알고리즘)
    private void inorder(Node p) {
        if (p != null) {
            inorder(p.leftChild);
            System.out.print(p.key + " ");
            inorder(p.rightChild);
        }
    }

    // 매개변수 없이 트리의 키값 합을 구하여 리턴** 합을 계산할 목적의 정적 변수나 인스턴스 변수를 두지 말고 구현해 볼 것** inorder와 비슷한 방식으로 구현하면 됨
    public int sum() {
        return sum(root);
    }

    // 트리의 모든 노드를 중위순회하며 합을 리턴
    private int sum(Node p) {
        if (p != null) {
            return sum(p.leftChild) + p.key + sum(p.rightChild); // 왼쪽 자식 노드 + 부모 노드 + 오른쪽 자식 노드
        }
        return 0; // 리프 노드면 0 리턴
    }

    // 정수 키값을 매개변수로 받아 트리에 검색하여 결과(true/false)를 리턴
    public boolean contains(int key) {
        return contains(root, key);
    }

    // 노드와 키 값을 매개변수로 받아 결과(true/false) 리턴
    public boolean contains(Node p, int key) {
        if (p != null) {
            if (key == p.key) { // 키 값을 찾으면 true
                return true;
            } else if (key < p.key) { // 찾는 키 값이 더 작으면 왼쪽 자식을 검색
                return contains(p.leftChild, key);
            } else if (key > p.key) { // 찾는 키 값이 더 크면 오른쪽 자식을 검색
                return contains(p.rightChild, key);
            }
        }
        return false; // 검색 실패시 false
    }
}
