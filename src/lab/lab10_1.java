// 무방향 그래프 구현
package lab;

import java.util.Scanner;

public class lab10_1 {
    public static void main(String[] args) {
        System.out.println("lab10_1:이길수");
        Scanner input = new Scanner(System.in);

        // (1) 정점이 5개인 무방향 그래프를 생성(graph)
        UndirectedListGraph graph = new UndirectedListGraph(5);

        // (2) 간선수 e와 e개의 간선을 입력받아 graph에 삽입
        int e = input.nextInt();
        for (int i = 0; i < e; i++) {
            graph.insertEdge(input.nextInt(), input.nextInt());
        }

        // (3) graph의 인접리스트 구현 내용을 출력
        graph.printAdjList();
        input.close();
    }
}

// 인접리스트로 구현한 무방향 그래프 클래스
class UndirectedListGraph {
    private class Node { // 단순 연결 리스트 노드 구조
        int vertex; // 정점 필드
        Node link; // 다음 노드를 연결하는 링크 필드
    }
    private Node[] list; // 인접리스트
    private int n; // vertex 개수

    public UndirectedListGraph(int n) { // 정점이 n개이고, 간선이 없는 그래프 생성
        list = new Node[n];
        this.n = n;
    }

    public void insertEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n) { // 그래프에 간선 <v1, v2> 삽입
            System.out.println("그래프에 없는 정점입니다!");
        } else {
            // v1의 연결 리스트 맨 앞에 vertex 필드가 v2인 노드 삽입
            Node newNode = new Node();
            newNode.vertex = v2;
            newNode.link = list[v1];
            list[v1] = newNode;
            // v2의 연결 리스트 맨 앞에 vertex 필드가 v1인 노드 삽입
            Node newNode2 = new Node();
            newNode2.vertex = v1;
            newNode2.link = list[v2];
            list[v2] = newNode2;
        } 
    }

    public void printAdjList() { // 인접 리스트를 모두 출력
        for (int i = 0; i < n; i++) {
            System.out.print("정점 "+ i +"의 인접리스트");
            for (Node temp = list[i]; temp != null; temp = temp.link) {
                System.out.print(" -> "+ temp.vertex);
            }
            System.out.println();
        }
    }
}