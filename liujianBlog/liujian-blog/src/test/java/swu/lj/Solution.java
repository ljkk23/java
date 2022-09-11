package swu.lj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] res=nextPermutation(new int[]{1,3,2});
        for (int a: res) {
            System.out.println(a);
        }
    }
    public static int[] nextPermutation(int[] nums) {
        int lenth= nums.length;
        int q=lenth-1;
        int p=0;
        Boolean flag=true;
        for (int i = q; i >0; i--) {
            if (nums[i]<=nums[i-1]){
                continue;
            }else {
                p=i-1;
                flag=false;
                break;
            }
        }
        if (!flag){
            for (int i = lenth-1; i >p ; i--) {
                if (nums[i]<=nums[p]){
                    continue;
                }else {
                    int temp=nums[p];
                    nums[p]=nums[i];
                    nums[i]=temp;
                    break;
                }
            }
            for (int i = p+1; i < lenth; i++) {
                for (int j = i; j < lenth; j++) {
                    if (nums[i]>nums[j]){
                        int tem=nums[i];
                        nums[i]=nums[j];
                        nums[j]=tem;
                    }
                }
            }
        }else {
            for (int i = p; i < lenth; i++) {
                for (int j = i; j < lenth; j++) {
                    if (nums[i]>nums[j]){
                        int tem=nums[i];
                        nums[i]=nums[j];
                        nums[j]=tem;
                    }
                }
            }
        }
        return nums;
    }
}