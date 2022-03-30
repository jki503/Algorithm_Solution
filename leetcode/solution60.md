# leetcode 1514. Path with Maximum Probability

- [문제 링크](https://leetcode.com/problems/path-with-maximum-probability/)

</br>

```java

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Node>> graph= new ArrayList<>();
        double[] probs = new double[n];

        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(int i = 0 ; i < edges.length; i++){
            int[] e = edges[i];
            int from = e[0];
            int to = e[1];
            double cost = succProb[i];

            graph.get(from).add(new Node(to,cost));
            graph.get(to).add(new Node(from,cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start,1));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int num = curr.num;
            double cost = curr.cost;

            if(probs[num] != 0 && probs[num] >= cost)
                continue;

            probs[num] = cost;

            if(num == end)
                continue;

            for(Node next : graph.get(num))
                pq.offer(new Node(next.num,cost*next.cost));

        }

        return probs[end];
    }

    class Node implements Comparable<Node>{
        int num;
        double cost;

        public Node(int num, double cost){
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n){
            return this.cost < n.cost ? 1 : -1;
        }
    }
}


```
