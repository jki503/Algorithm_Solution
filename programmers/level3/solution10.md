# 프로그래머스 LEVEL 3 2021 Dev-Matching: 웹 백엔드 개발자(상반기) 다단계 칫솔 판매

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/77486?language=java)

</br>

```java

import java.util.HashMap;

class Solution {

    class Person{

        String name;
        Person ref;
        int profit;

        Person(String name, Person ref, int profit){
            this.name = name;
            this.ref = ref;
            this.profit = profit;
        }

        public void calcProfit(int profit){
            int refProfit = profit / 10;
            this.profit += profit - refProfit;

            // 추천자로 갈 이익이 0 원 미만
            if(refProfit < 0)
                return;

            // 추천자가 없으면
            if(this.ref == null)
                return;

            // 추천자 이익 갱신
            this.ref.calcProfit(refProfit);

        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        HashMap<String,Person> map = new HashMap<>();
        int n = enroll.length;

        // map 세팅
        for(int i=0;i<n;i++){
            String name = enroll[i];
            map.put(name, new Person(name,null,0));

        }

        for(int i=0;i<n; i++){

            String name = enroll[i];
            String ref = referral[i];

            // 추천자 없으면 continue;
            if(ref.equals("-"))
                continue;

            // 추천자 설정
            map.get(name).ref = map.get(ref);

        }


        for(int i=0;i<seller.length;i++){

            String sellerName = seller[i];
            int profit = amount[i] * 100;

            // 이익 갱신
            map.get(sellerName).calcProfit(profit);
        }

        answer = new int[n];

        for(int i=0;i < n; i++){
            String name = enroll[i];
            answer[i] = map.get(name).profit;
        }

        return answer;
    }
}

```
