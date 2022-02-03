# 프로그래머스 LEVEL 2 2017 카카오코드 본선 단체 사진 찍기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/1835?language=java)

</br>

```java
import java.lang.Math;

class Solution {

    int answer;
    String[] data;
    boolean[] visited;
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public int solution(int n, String[] data) {

        // 변수 초기화
        this.answer = 0;
        this.data = data;
        this.visited = new boolean[8];

        dfsLine("");

        return answer;
    }

    public void dfsLine(String line){

        // 탈출 조건
        if(line.length()==8){

            // 친구들을 줄 세웠을때 조건을 충족하면
            if(checkValid(line)){
                answer++;
            }
            return;
        }

        for(int i=0;i<8;i++){

            // 방문했으면 continue;
            if(visited[i])
                continue;

            visited[i] = true;
            dfsLine(line + friends[i]);
            visited[i] = false;
        }
    }

    public boolean checkValid(String line){

        for(int i=0 ;i<data.length;i++){

            // 현재 data의 조건
            String curr = data[i];

            // 친구들 사이 거리
            int f1 = line.indexOf(curr.charAt(0));
            int f2 = line.indexOf(curr.charAt(2));
            int distff = Math.abs(f1 - f2);

            // 연산자
            char op = curr.charAt(3);

            // 거리
            int dist = curr.charAt(4) - '0'+1;

            // 연산 거리 조건
            if(op == '='){
                if(distff != dist) return false;
            }
            else if(op == '>'){
                if(!(distff > dist)) return false;
            }
            else if(op == '<'){
                if(!(distff < dist)) return false;
            }

        }
        return true;

    }

}

```
