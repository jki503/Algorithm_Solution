# leetcode 94. Binary Tree Inorder Traversal

- [문제 링크](https://leetcode.com/problems/binary-tree-inorder-traversal/)

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    private void inorder(TreeNode node, List<Integer> orders){
        if(node == null){
            return;
        }

        inorder(node.left, orders);
        orders.add(node.val);
        inorder(node.right, orders);
    }
}
```
