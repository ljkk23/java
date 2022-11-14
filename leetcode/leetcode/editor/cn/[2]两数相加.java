//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 8447 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode headNode=null;
        ListNode p=headNode;
        //进位
        Integer addNum=0;
        Integer sum=0;
        while (p1!= null && p2!=null){
            sum=p1.val+p2.val+addNum;
            if (sum>=10)
            {
                addNum=1;
            }else {
                addNum=0;
            }
            if (headNode==null){
                headNode=p=new ListNode(sum%10);
            }else {
                //这是错误写法：p.next=new ListNode();
                //正确写法
                p.next=new ListNode(sum%10);
                p=p.next;
            }
            p1=p1.next;
            p2=p2.next;
        }
        while (p1!=null || p2!=null){
            if (p1!=null){
                sum=p1.val+addNum;
                if (sum>=10)
                {
                    addNum=1;
                }else {
                    addNum=0;
                }
                p.next=new ListNode(sum%10);
                p=p.next;
                p1=p1.next;
            } else if (p2!=null) {
                sum=p2.val+addNum;
                if (sum>=10)
                {
                    addNum=1;
                }else {
                    addNum=0;
                }
                p.next=new ListNode(sum%10);
                p=p.next;
                p2=p2.next;
            }
        }

        if (addNum!=0){
            p.next=new ListNode(1);
        }
        return headNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
