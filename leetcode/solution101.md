# leetcode 1448. Count Good Nodes in Binary Tree

- [문제 링크](https://leetcode.com/problems/count-good-nodes-in-binary-tree/)

```java
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

    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        return 1 + countGoodNodes(root.left, root.val) + countGoodNodes(root.right, root.val);
    }

    private int countGoodNodes(TreeNode node, int maxVal){
        if(node == null){
            return 0;
        }

        int currVal = node.val;

        if(currVal >= maxVal){
            return 1 + countGoodNodes(node.left, currVal) +  countGoodNodes(node.right, currVal);
        }

        return countGoodNodes(node.left, maxVal) +  countGoodNodes(node.right, maxVal);
    }
}
```
