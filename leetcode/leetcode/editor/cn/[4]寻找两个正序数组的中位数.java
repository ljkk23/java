//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 5768 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> mylist=new ArrayList<Integer>();
        for (int a: nums1) {
            mylist.add(Integer.valueOf(a));
        }
        for (int a: nums2) {
            mylist.add(Integer.valueOf(a));
        }
        Collections.sort(mylist);
        System.out.println(mylist);
        System.out.println(mylist.size());
        double result=0;
        if (mylist.size()%2!=0){
            //为奇数
            result= mylist.get(((mylist.size()+1)/2)-1);
        }else {
            double sum=Double.valueOf(mylist.get(mylist.size()/2-1)+mylist.get(mylist.size()/2));
            result=sum/2;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
