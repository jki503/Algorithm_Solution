# 프로그래머스 LEVEL 2 2018 KAKAO BLIND RECRUITMENT [1차] 프렌즈4블록

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17679?language=java)

</br>

```java

class Solution {

    char[][] map;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        // char 배열로 변환
        this.map = new char[m][n];
        for(int i=0;i<m;i++){
            map[i] = board[i].toCharArray();
        }

        while(true){
            int cnt = countBlock(m, n);
            // 더 이상 지울 수 없음으로
            if(cnt==0)
                break;
            answer+=cnt;

            dropBlock(m,n);
        }


        return answer;
    }

    public int countBlock(int m, int n){
        int cnt = 0;
        boolean[][] deleted = new boolean[m][n];

        for(int i = 0 ; i < m-1 ; i++)
            for(int j=0; j < n-1; j++){
                // 지워진 부분이면 continue;
                if(map[i][j] == '.')
                    continue;
                // 지워지는 4개인지 탐색
                checkFour(i,j,deleted);
            }

        // 지워진 부분 cnt++;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(deleted[i][j]){
                    map[i][j] = '.';
                    cnt++;
                }
            }

        return cnt;
    }


    public void checkFour(int row, int col, boolean[][] deleted){

        // friend
        char f = map[row][col];

        for(int i=row ; i < row + 2 ; i++){
            for(int j= col ; j < col + 2 ; j++){
                // 삭제 할 수 없으면 종료
                if(map[i][j]!= f)
                    return;
            }
        }

        for(int i=row ; i< row+2 ; i++){
            for(int j=col ; j < col + 2 ; j++){
                // 삭제 갱신
                deleted[i][j] = true;
            }
        }
    }

    // 지운 부분 떨어뜨리기
    public void dropBlock(int m, int n){

        // 열
        for(int j=0;j<n;j++){
            // 행
            for(int i= m-1 ; i>=0 ; i--){
                if(map[i][j] == '.'){
                    for(int k = i-1 ; k >=0; k--){
                        if(map[k][j] != '.'){
                            map[i][j] = map[k][j];
                            map[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}

```
