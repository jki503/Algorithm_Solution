# 프로그래머스 LEVEL 1 체육복

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42862?language=java)

</br>

```java

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] students = new int[n];

        for(int l : lost)
            students[l-1]-=1;

        for(int r : reserve)
            students[r-1]+=1;

        for(int i=0;i<n;i++){

            // 체육복 없을때
            if(students[i] == -1){

                // 앞번호가 가능할때
                if(i!=0 && students[i-1] > 0){
                    students[i-1]-=1;
                    students[i]+=1;
                }
                else if(i != n-1 && students[i+1] > 0){
                    // 뒷 번호가 가능 할때
                    students[i+1]-=1;
                    students[i]+=1;
                }

            }

        }

        for(int s : students)
            if(s >= 0)
                answer++;

        return answer;
    }
}

```
