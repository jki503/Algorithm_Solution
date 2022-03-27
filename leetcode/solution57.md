# leetcode 399. Evaluate Division

- [문제 링크](https://leetcode.com/problems/evaluate-division/)

```java

import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String,List<Node>> graphMap = new HashMap<>();

        int n = values.length;
        double[] result = new double[queries.size()];
        Arrays.fill(result,-1);

        for(int i=0; i < n; i++){

            List<String> e = equations.get(i);

            String from = e.get(0);
            String to = e.get(1);

            graphMap.computeIfAbsent(from, o -> new ArrayList<>()).add(new Node(to,values[i]));
            graphMap.computeIfAbsent(to, o -> new ArrayList<>()).add(new Node(from,1/values[i]));

        }

        for(int i=0; i < queries.size(); i++){

            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);

            if(!graphMap.containsKey(start) || !graphMap.containsKey(end))
                continue;

            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(start,1));
            Set<String> visitedSet = new HashSet<>();

            while(!q.isEmpty()){

                Node curr = q.poll();

                String name = curr.name;

                double cost = curr.cost;

                // check visited
                if(visitedSet.contains(name))
                    continue;

                visitedSet.add(name);

                // check arrive
                if(name.equals(end)){
                    result[i] = cost;
                    break;
                }

                for(Node next : graphMap.get(name))
                    q.offer(new Node(next.name,cost * next.cost));

            }

        }

        return result;

    }

    class Node{

        String name;
        double cost;

        public Node(String name, double cost){
            this.name = name;
            this.cost = cost;
        }
    }
}

```
