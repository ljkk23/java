//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 8041 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {

        long startTime=System.currentTimeMillis();
        System.out.println(lengthOfLongestSubstring("aaaa"));
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Character> myhash=new HashMap<>();
        List<Integer> myList=new ArrayList<Integer>();
//        myList.add(3);
//        myList.add(4);
//        myList.add(5);
//        System.out.println(myList.stream().max(Integer::compareTo));
        int j=0;
        while (true){
            for (int i = j; i < s.length(); i++) {
                char tempChar=s.charAt(i);
                if (myhash.containsValue(tempChar)){
                    myList.add(Integer.valueOf(i-j));
                    j=i;
                    myhash.clear();
                    break;
                }
                myhash.put(tempChar,tempChar);
                if (i==s.length()-1){
                    myList.add(Integer.valueOf(i+1-j));
                    return myList.stream().max(Integer::compare).get();
                }
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
