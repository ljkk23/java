//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1414 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
    public int maxDepth(TreeNode root) {
        int res=0;
        Stack<TreeNode> treeNodeStack=new Stack<TreeNode>();
        if (root==null){
            return res;
        }
        TreeNode cur=root;
        TreeNode pre=null;
        while (!treeNodeStack.isEmpty() || cur!=null){
            while (cur!=null){
                treeNodeStack.push(cur);
                cur=cur.left;
            }
            TreeNode tmp= treeNodeStack.pop();
            if (tmp.right!=null && tmp.right!=pre){
                treeNodeStack.push(tmp);
                cur=tmp.right;

            }else {
                if (treeNodeStack.size()+1>res){
                    res=treeNodeStack.size()+1;
                }
                pre=tmp;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
