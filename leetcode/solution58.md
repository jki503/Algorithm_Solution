# leetcode 743. Network Delay Time

- [문제 링크](https://leetcode.com/problems/network-delay-time/)

</br>

```java

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Node>> graphMap = new HashMap<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        // setting edges data
        for(int[] t : times){
            int from = t[0];
            int to = t[1];
            int cost = t[2];

            graphMap.computeIfAbsent(from,o -> new ArrayList<>()).add(new Node(to,cost));
        }


        PriorityQueue<Node> pq = new PriorityQueue<>();

        // source network
        pq.offer(new Node(k,0));

        while(!pq.isEmpty()){

            Node curr = pq.poll();

            int num = curr.num;
            int cost = curr.cost;

            if(cost >= dist[num])
                continue;

            dist[num] = cost;

            if(!graphMap.containsKey(num))
                continue;

            for(Node next : graphMap.get(num))
                pq.offer(new Node(next.num, cost + next.cost));

        }

        int answer = Integer.MIN_VALUE;

        // check possible
        for(int i = 1; i <= n; i++)
            if(dist[i] == Integer.MAX_VALUE){
                answer = -1;
                break;
            }
            else
                answer = answer < dist[i] ? dist[i] : answer;


        return answer;
    }

    class Node implements Comparable<Node>{

        int num;
        int cost;

        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n){
            return this.cost < n.cost ? -1 : 1;
        }


    }

}

```
