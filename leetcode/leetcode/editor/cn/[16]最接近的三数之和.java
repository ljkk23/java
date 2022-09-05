//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1228 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int res=nums[length-3]+nums[length-2]+nums[length-1];
        int min=Math.abs(res-target);
        for (int i = 0; i < length - 1; i++) {
            //去重，当起始的值等于前一个元素，那么得到的结果将会和前一次相同
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //为什么l就是i+1,因为l肯定在i的右侧，如果在l在i的左侧，就会重复
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (target==sum){
                    return sum;
                }
                if (Math.abs(target-sum)<min) {
                    min=Math.abs(target-sum);
                    res=sum;
                    //去重，因为 i 不变，当此时 l取的数的值与前一个数相同，所以不用在计算，直接跳
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    //去重，因为 i不变，当此时 r 取的数的值与前一个相同，所以不用在计算
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                }
                if (target>sum){
                    l++;
                } else {
                    r--;
                }

            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
