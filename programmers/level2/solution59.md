# 프로그래머스 LEVEL 2 2022 KAKAO BLIND RECRUITMENT 양궁대회

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/92342?language=java)

</br>

```java

class Solution {

    private static final int SIZE = 11;
    int max = 0;
    int[] answer;
    int[] ryan;

    public int[] solution(int n, int[] info) {

        ryan = new int[SIZE];
        answer = new int[SIZE];

        // 어피치가 얻을 수 있는 점수
        int apeach = 0;
        for(int i = 0 ; i < info.length; i++){
            if(info[i]!=0)
                apeach += 10-i;
        }

        // 탐색
        dfs(0,n, 0, apeach, info);

        // 이길 수 없을때
        if(max == 0)
            answer = new int[]{-1};

        return answer;
    }

    private void dfs(int idx, int n, int rScore, int aScore, int[] info){

        if(idx == SIZE){

            // 화살을 다 안 쓰면
            if(n > 0 )
                ryan[SIZE-1] += n;

            // ryan이 apeach를 이길 경우
            if(checkWin(rScore,aScore)){
                max = rScore - aScore;
                answer = ryan.clone();
            }

            return;
        }

        // 포인트를 얻을 때
        if(n >= info[idx] + 1){

            ryan[idx] = info[idx] + 1; // 포인트를 얻는 최소 개수 설정

            int currScore = 10 - idx;

            if(info[idx] != 0)
                dfs(idx+1,n - ryan[idx], rScore + currScore, aScore - currScore , info);
            else
                dfs(idx+1,n - ryan[idx], rScore + currScore, aScore, info);


        }

        ryan[idx] = 0; // 갱신

        // 포인트를 못 얻을때
        dfs(idx+1,n,rScore, aScore, info);
    }

    private boolean checkWin(int rScore, int aScore){

        if(max < rScore - aScore )
            return true;
        else if(max == rScore - aScore){
            for(int i=SIZE - 1 ; i >= 0; i--){
                if(ryan[i] > answer[i]) // 낮은 화살이 더 많을 경우
                    return true;
                else if(ryan[i] < answer[i])
                    break;
            }
        }

        return false;
    }

}

```
