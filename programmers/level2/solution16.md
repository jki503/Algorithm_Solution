# 프로그래머스 LEVEL 2 Summer/Winter Coding(~2018) 방문 길이

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/49994?language=java)

</br>

```java

class Solution {


    int SIZE = 11;


    public int solution(String dirs) {
        int answer = 0;

        // 초기 map 세팅
        boolean[][][][] visited = new boolean[SIZE][SIZE][SIZE][SIZE];
        int r = 5;
        int c = 5;
        int rr = 0;
        int cc = 0;

        for(int i=0;i<dirs.length();i++){
            char dir = dirs.charAt(i);

            // 방향 정하기
            if(dir == 'U'){
                rr = r-1;
                cc = c;
            }
            else if(dir == 'R'){
                rr = r;
                cc = c+1;
            }
            else if(dir == 'D'){
                rr = r+1;
                cc = c;
            }
            else if(dir == 'L'){
                rr = r;
                cc = c-1;
            }
            // 유효하지 않으면 무시
            if(!checkValid(rr,cc)){
                continue;
            }

            // 양방향 체크
            if(!visited[r][c][rr][cc] && !visited[rr][cc][r][c])
                answer++;


            // 방문 갱신후 증가
            visited[r][c][rr][cc] = true;
            r = rr;
            c = cc;

        }

        return answer;
    }

    public boolean checkValid(int r, int c){
        if((r<0 || r>=SIZE
        || c<0 || c>=SIZE))
            return false;
        return true;
    }

}

```
