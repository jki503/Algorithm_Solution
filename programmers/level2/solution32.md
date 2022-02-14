# 프로그래머스 2020 카카오 인턴십 순위 검색

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/67257?language=java)

</br>

```java

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;


class Solution {

    char[] opArr = {'+','-','*'};
    List<Long> numbers;
    List<Character> operands;
    boolean[] check;

    long answer;
    public long solution(String expression) {
        this.answer = 0;

        this.numbers = new ArrayList<>();
        this.operands = new ArrayList<>();
        this.check = new boolean[3];

        StringBuilder numSb = new StringBuilder();
        for(int i=0;i<expression.length();i++){
            char curr = expression.charAt(i);

            if(curr >='0' && curr <='9')
                numSb.append(curr);
            else{
                numbers.add(Long.parseLong(numSb.toString()));
                numSb.setLength(0);
                operands.add(curr);
            }

        }
        numbers.add(Long.parseLong(numSb.toString()));

        combi(0, new char[3]);

        return answer;
    }


    // + - * 수열 결과 갱신
    public void combi(int cnt, char[] op){
        if(cnt == 3){

            List<Long> nums = new ArrayList<>(numbers);
            List<Character> ops = new ArrayList<>(operands);

            for(int i=0;i<op.length;i++){
                char currOp = op[i];
                for(int j=0;j<ops.size();j++){
                    if(currOp == ops.get(j)){
                        Long result = calc(nums.remove(j),nums.remove(j),currOp);
                        nums.add(j,result);
                        ops.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(nums.get(0)));
            return;
        }

        // 탐색
        for(int i=0;i<opArr.length;i++){
            if(!check[i]){
                check[i] = true;
                op[cnt] = opArr[i];
                combi(cnt+1, op);
                check[i] = false;
            }
        }
    }

    // 계산
    public Long calc(Long num1, Long num2, char op){

        if(op == '+'){
            return num1 + num2;
        }
        else if(op == '-'){
            return num1 - num2;
        }
        else if(op == '*')
            return num1 * num2;

        return 0L;
    }
}

```
