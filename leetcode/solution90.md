# leetcode 513. Find Bottom Left Tree Value

- [문제 링크](https://leetcode.com/problems/find-bottom-left-tree-value/)

```java

import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int answer = 0;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (q.size() > 0){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                if(curr.right != null){
                    q.offer(curr.right);
                }

                if(curr.left != null){
                    q.offer(curr.left);
                }
                answer = curr.val;
            }
        }

        return answer;
    }
}
```
