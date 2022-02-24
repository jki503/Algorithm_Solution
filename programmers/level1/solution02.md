# 프로그래머스 LEVEL 1 2021 Dev-Matching: 웹 백엔드 개발자(상반기) 로또의 최고 순위와 최저 순위

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/77484?language=java)

</br>

```java

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int[] rank = {6,6,5,4,3,2,1};
        int low = 0;
        int high = 0;


        for(int l : lottos){

            if(l==0){
                high++;
                continue;
            }

            for(int w : win_nums){
                if(l==w){
                    low++;
                    break;
                }
            }

        }

        high+=low;

        answer[0] = rank[high];
        answer[1] = rank[low];

        return answer;
    }
}

```
