# leetcode 113. Path Sum II

- [문제 링크](https://leetcode.com/problems/path-sum-ii/)

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

    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>(), 0, targetSum);
        return answer;
    }

    private void dfs(TreeNode node, List<Integer> subList, int sum, int targetSum){
        if(node == null){
            return;
        }
        subList.add(node.val);
        sum += node.val;

        if(node.left == null && node.right == null && sum == targetSum){
            answer.add(new ArrayList<>(subList));
        }
        else{
            dfs(node.left, subList, sum,  targetSum);
            dfs(node.right, subList, sum, targetSum);
        }
        subList.remove(subList.size() - 1);
    }
}
```
