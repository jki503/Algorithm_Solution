# leetcode 129. Sum Root to Leaf Numbers

- [문제 링크](https://leetcode.com/problems/sum-root-to-leaf-numbers/)

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
    private int answer = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return answer;
        }
        dfs(root, new StringBuilder());
        return answer;
    }

    private void dfs(TreeNode node, StringBuilder pathSb){
        if(node == null){
            return;
        }

        pathSb.append(node.val);

        if(node.left == null && node.right == null){
            answer += Integer.parseInt(pathSb.toString());
            return;
        }

        dfs(node.left, new StringBuilder(pathSb.toString()));
        dfs(node.right, new StringBuilder(pathSb.toString()));
    }
}
```
