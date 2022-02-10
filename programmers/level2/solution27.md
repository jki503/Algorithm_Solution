# 프로그래머스 LEVEL 2 월간 코드 챌린지 시즌1 쿼드압축 후 개수 세기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/68936?language=java)

</br>

```java

class Solution {

    int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];

        quardZip(0,0,arr.length,arr);

        return answer;
    }

    public void quardZip(int r, int c, int n, int[][]arr){

        //어떤 걸로 압축할지 체크

        boolean checkZero = true;
        boolean checkOne = true;

        for(int i=r;i<r+n;i++){

            // 더이상 탐색 할 필요 X
            if(!checkZero && !checkOne)
                break;

            for(int j=c;j<c+n;j++){
                if(arr[i][j] == 1)
                    checkZero = false;
                else
                    checkOne = false;

            }

        }

        if(checkZero){
            answer[0]++;
            return;
        }
        if(checkOne){
            answer[1]++;
            return;
        }

        // 4개로 divdie
        quardZip(r,c,n/2,arr);
        quardZip(r+n/2,c,n/2,arr);
        quardZip(r,c+n/2,n/2,arr);
        quardZip(r+n/2,c+n/2,n/2,arr);
    }
}

```
