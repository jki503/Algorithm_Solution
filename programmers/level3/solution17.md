# 프로그래머스 LEVEL 3 2021 카카오 채용연계형 인턴십 표 편집

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/81303?language=java)

</br>

```java

import java.util.Stack;

class Solution {

    /*
        hist : 삭제 기록
        curr : 현재 위치
        size : cell의 사이즈
    */
    Stack<Integer> hist;
    int size;
    int location;

    public String solution(int n, int k, String[] cmd) {

        String answer = "";

        hist = new Stack<>();
        location = k;
        size = n;

        for(String c : cmd){

            char action = c.charAt(0);

            switch(action){

                case 'U' : location -=Integer.parseInt(c.substring(2));
                    break;
                case 'D' : location +=Integer.parseInt(c.substring(2));
                    break;
                case 'C' : delete();
                    break;
                case 'Z' : revert();
                    break;

            }

        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<size; i++){
            sb.append("O");
        }

        // 삭제 된 위치에 X
        while(!hist.empty()){
            sb.insert(hist.pop().intValue(),"X");
        }

        answer = sb.toString();

        return answer;
    }

    public void delete(){
        hist.add(location);
        size-=1;
        // 현재 위치가 size면 -1
        if(location == size){
            location-=1;
        }

    }

    public void revert(){

        // 삭제 된 행 <= 현재 행 -> 아래로 이동
        if(hist.pop() <= location)
            location+=1;

        size+=1;
    }
}

```
