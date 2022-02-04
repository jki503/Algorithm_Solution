# 프로그래머스 LEVEL 3 여행경로

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/43164?language=java)

</br>

```java

import java.util.ArrayList;
import java.util.Collections;

/*
    실수 했던 것
    : tickets 정렬하고, 순서대로 방문 한 결과 testCase1, 2 실패

    ex)
        A->B,C가 가능 한 경우,
        B에서 C로 가는 티켓이 없으면 탐색 실패.

        즉, 가능한 경로에서 가장 작은 경로를 정답으로 뽑아야함...
*/

class Solution {

    /*
        list :course 저장
        visited : 티켓 사용여부
    */
    ArrayList<String> list;
    boolean[] visited;


    public String[] solution(String[][] tickets) {
        String[] answer={};

        // 변수 설정
        list = new ArrayList<>();
        visited = new boolean[tickets.length];

        // 경로 가능한지 탐색
        searchCourse("ICN","ICN",0,tickets);

        // 모든 경로 중 최소
        answer = Collections.min(list).split(" ");

        return answer;
    }

    public void searchCourse(String curr, String course, int count, String[][] tickets){

        // 탈출 조건 -> course 저장
        if(count == tickets.length){
            list.add(course);
            return;
        }

        for(int i=0;i<tickets.length;i++){

            // 사용X, 현재 위치와 티켓 출발지가 같으면
            if(!visited[i] && curr.equals(tickets[i][0])){
                String next = tickets[i][1];

                visited[i] = true;
                searchCourse(next, course + " " + next, count+1, tickets);
                visited[i] = false;
            }
        }
    }

}

```
