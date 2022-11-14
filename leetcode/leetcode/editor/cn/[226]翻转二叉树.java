//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1428 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

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
    public TreeNode invertTree(TreeNode root) {
//        if (root==null){
//            return null;
//        }
//        TreeNode tmp=root.left;
//        root.left=root.right;
//        root.right=tmp;
//        invertTree(root.left);
//        invertTree(root.right);
//        return root;
        if (root==null){
            return root;
        }
        Queue<TreeNode> myQueue=new LinkedList<>();
        myQueue.offer(root);
        while(!myQueue.isEmpty()){
            TreeNode cur= myQueue.poll();;
            TreeNode tmp=cur.left;
            cur.left=cur.right;
            cur.right=tmp;
            if (cur.left!=null){
                myQueue.offer(cur.left);
            }
            if (cur.right!=null){
                myQueue.offer(cur.right);
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
