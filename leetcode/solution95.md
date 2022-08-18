# 98. Validate Binary Search Tree

- [문제 링크](https://leetcode.com/problems/validate-binary-search-tree/)

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
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    private boolean validateBST(TreeNode root, Integer low, Integer high) {
	    if (root == null)
		    return true;

	    if (low != null && root.val <= low || high != null && root.val >= high)
		    return false;

	    boolean isLeftSubtreeValid = validateBST(root.left, low, root.val);
	    boolean isRightSubtreeValid = validateBST(root.right, root.val, high);

	    return isLeftSubtreeValid && isRightSubtreeValid;
    }
}
```
