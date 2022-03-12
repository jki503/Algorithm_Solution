# leetcode 12. Integer to Roman

- [문제 링크](https://leetcode.com/problems/integer-to-roman/)

</br>

```java

class Solution {

    private static final int arr[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] romans = {"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        int i=0;

        while(num !=0 ){

            if(num >= arr[i]){
                num -= arr[i];
                sb.append(romans[i]);
            }
            else
                i++;
        }


        return sb.toString();
    }
}

```
