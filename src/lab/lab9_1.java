// binary search tree 삽입/순회
package lab;

import java.util.Scanner;

public class lab9_1 {
    public static void main(String[] args) {
        System.out.println("lab9_1:이길수");

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
}
