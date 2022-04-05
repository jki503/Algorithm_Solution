# 프로그래머스 LEVEL 3 2019 KAKAO BLIND RECRUITMENT 길찾기 게임

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42892?language=java)

</br>

```java

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        List<Node> nodeList = new ArrayList<>();

        for(int i = 0; i < nodeinfo.length; i++)
            nodeList.add(new Node(nodeinfo[i][0], nodeinfo[i][1],i+1));

        // y 내림차순, x 오름차순
        Collections.sort(nodeList, (o1, o2)
                    -> o1.y == o2.y ? o1.x - o2.x : o2.y - o1.y);

        // 노드 연결
        Node root = nodeList.get(0);
        for(int i = 1; i < nodeList.size(); i++)
            insertNode(root, nodeList.get(i));

        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> postOrderList = new ArrayList<>();

        preOrder(root, preOrderList);
        postOrder(root, postOrderList);

        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    private void insertNode(Node parent, Node child){

        if(parent.x > child.x){
            // 왼쪽
            if(parent.left == null)
                parent.left = child;
            else
                insertNode(parent.left, child);
        }
        else{
            if(parent.right == null)
                parent.right = child;
            else
                insertNode(parent.right, child);
        }

    }

    private void preOrder(Node curr, List<Integer> list){
        if(curr == null)
            return;
        list.add(curr.num);
        preOrder(curr.left, list);
        preOrder(curr.right, list);
    }

    private void postOrder(Node curr, List<Integer> list){
        if(curr == null)
            return;
        postOrder(curr.left,list);
        postOrder(curr.right,list);
        list.add(curr.num);
    }

    class Node{
        int x;
        int y;
        int num;
        Node left;
        Node right;

        public Node(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}



```
