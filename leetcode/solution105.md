# leetcode 429. N-ary Tree Level Order Traversal

- [문제 링크](https://leetcode.com/problems/n-ary-tree-level-order-traversal/submissions/)

```java
import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subList = new ArrayList<>();

            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                subList.add(curr.val);

                if(curr.children == null){
                    continue;
                }

                for(Node child : curr.children){
                    q.offer(child);
                }
            }
            ans.add (subList);
        }

        return ans;
    }
}
```
