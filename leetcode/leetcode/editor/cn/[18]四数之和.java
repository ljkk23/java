//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1364 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int lenth=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        if (lenth<4){
            return res;
        }
        if (lenth==4){
            if ((long)nums[0]+nums[1]+nums[2]+nums[3]==(long) target){
                System.out.println(nums[0]+nums[1]+nums[2]+nums[3]);
                res.add(Arrays.asList(nums[0],nums[1],nums[2],nums[3]));
                return res;
            }else
                return res;

        }
        for (int i = 0; i < lenth-3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[lenth - 3] + nums[lenth - 2] + nums[lenth - 1] < target) {
                continue;
            }
            for (int j = i+1; j < lenth-2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[lenth - 2] + nums[lenth - 1] < target) {
                    continue;
                }
                int l=j+1;
                int r=lenth-1;
                while (l<r){
                    if ((long)nums[i]+nums[j]+nums[l]+nums[r]==(long)target){
                        if (!res.contains(Arrays.asList(nums[i],nums[j],nums[l],nums[r]))){
                            res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        }
                        while (l<r && nums[r]==nums[r-1]){
                            r--;
                        }
                        while (l<r && nums[l]==nums[l+1]){
                            l++;
                        }
                        l++;
                        r--;
                    } else if ((long)nums[i]+nums[j]+nums[l]+nums[r]>(long)target) {
                        while (l<r && nums[r]==nums[r-1]){
                            r--;
                        }
                        r--;
                    } else if ((long)nums[i]+nums[j]+nums[l]+nums[r]<(long)target) {
                        while (l<r && nums[l]==nums[l+1]){
                            l++;
                        }
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
