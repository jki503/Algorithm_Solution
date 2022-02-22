# 프로그래머스 LEVEL 3 2020 KAKAO BLIND RECRUITMENT 기둥과 보 설치

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/60061?language=java)

</br>

```java

class Solution {

    boolean[][] pill; //기둥 위치
    boolean[][] bar; // 보 위치


    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};

        pill = new boolean[n+1][n+1];
        bar = new boolean[n+1][n+1];

        int size=0;

        for(int[] build : build_frame){

            int x = build[0];
            int y = build[1];
            int type = build[2];
            int cmd = build[3];

            if(cmd == 1){
                // 설치
                if(type == 0){
                    if(!checkPill(x,y))
                        continue;
                    size++;
                    pill[x][y] = true;
                }
                else{
                    if(!checkBar(x,y))
                        continue;
                    size++;
                    bar[x][y] = true;
                }
            }
            else{
                // 삭제
                if(type==0) pill[x][y] = false;
                else bar[x][y] = false;

                if(checkDelete(n)){
                    size--;
                    continue;
                }

                if(type==0) pill[x][y] = true;
                else bar[x][y] = true;

            }

        }

        answer = new int[size][3];

        int i=0;
        for(int x=0;x<=n;x++)
            for(int y=0;y<=n;y++){
                if(pill[x][y]){
                    answer[i][0] = x;
                    answer[i][1] = y;
                    answer[i++][2] = 0;
                }
                if(bar[x][y]){
                    answer[i][0] = x;
                    answer[i][1] = y;
                    answer[i++][2] = 1;
                }

            }

        return answer;
    }

    public boolean checkPill(int x, int y){
        if(y==0) return true; // 1.
        if(y>0 && pill[x][y-1]) return true; //2. 기둥 위면
        if(x > 0 && bar[x-1][y] || bar[x][y]) return true; // 3. 보 위면

        return false;
    }

    public boolean checkBar(int x, int y){

        if(y>0 && pill[x][y-1] || pill[x+1][y-1]) return true; // 1. 기둥 위면
        if(x>0 && bar[x-1][y] && bar[x+1][y]) return true; // 2. 보 위면

        return false;
    }

    public boolean checkDelete(int n){

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(pill[i][j] && !checkPill(i,j)) return false; // 기둥
                if(bar[i][j] && !checkBar(i,j)) return false; // 보
            }
        }

        return true;
    }
}

```
