//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
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
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1487 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        Queue<TreeNode> treeNodeQueue=new LinkedList<TreeNode>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()){
            List<Integer> integerList=new ArrayList<>();
            int queueSize=treeNodeQueue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode pollNode = treeNodeQueue.poll();
                integerList.add(pollNode.val);
                if (pollNode.left!=null){
                    treeNodeQueue.offer(pollNode.left);
                }
                if (pollNode.right!=null){
                    treeNodeQueue.offer(pollNode.right);
                }
            }
            result.add(integerList);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
