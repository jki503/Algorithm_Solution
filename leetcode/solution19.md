# leetcode 451. Sort Characters By Frequency

- [문제 링크](https://leetcode.com/problems/sort-characters-by-frequency/)

</br>

```java

import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;


class Solution {
    public String frequencySort(String s) {

        PriorityQueue<CharObj> pq = new PriorityQueue<>();
        Set<Character> set = new HashSet<>();

        int[] arr = new int[128];

        for(char c : s.toCharArray())
            arr[c - '0'] ++;

        for(char c : s.toCharArray()){

            if(set.add(c))
                pq.offer(new CharObj(c,arr[c-'0']));
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){

            CharObj curr = pq.poll();

            for(int i=0; i < curr.frequency; i++)
                sb.append(curr.c);

        }

        return sb.toString();
    }


    class CharObj implements Comparable<CharObj>{

        char c;
        int frequency;


        public CharObj(char c, int frequency){

            this.c = c;
            this.frequency = frequency;

        }

        @Override
        public int compareTo(CharObj charObj){

            if(this.frequency < charObj.frequency)
                return 1;
            else
                return -1;
        }

    }

}

```
