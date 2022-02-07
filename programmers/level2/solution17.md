# 프로그래머스 LEVEL 2 Summer/Winter Coding(~2018) 스킬 트리

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/49993?language=java#fnref1)

</br>

```java



class Solution {

    char[] prior;

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        // 스킬 우선 순위
        prior = skill.toCharArray();

        for(String tree : skill_trees){

            // 올바른 스킬 트리면 증가
            if(checkValid(tree)){
                answer++;
            }
        }

        return answer;
    }

    public boolean checkValid(String s){

        /*
            curr : 현재스킬
            안배웠으면 -1 반환
        */
        int curr = s.indexOf(prior[0]);

        for(int i=1;i<prior.length;i++){

            // 다음 스킬
            int next = s.indexOf(prior[i]);

            if(curr < 0){
                // 선행 스킬이 없는데
                if(next >= 0)
                    // 스킬 배웠으면
                    return false;
            }
            else{
                // 스킬 먼저 배웠으면
                if(next!=-1 && next < curr)
                    return false;
            }

            curr = next;
        }

        return true;
    }
}

```
