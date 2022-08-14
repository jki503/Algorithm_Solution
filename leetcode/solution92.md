# 235. Lowest Common Ancestor of a Binary Search Tree

- [문제 링크](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode answer = root;

        while(true){
            if(answer.val < p.val && answer.val < q.val){
                answer = answer.right;
                continue;
            }

            if(answer.val > p.val && answer.val > q.val){
                answer = answer.left;
                continue;
            }

            break;
        }

        return answer;
    }
}
```
