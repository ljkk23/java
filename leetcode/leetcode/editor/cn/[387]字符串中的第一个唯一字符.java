//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
//
// Related Topics 队列 哈希表 字符串 计数 👍 612 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int lenth=s.length();
        Map<String,Integer> myhashMap=new HashMap<>();
        for (int i = 0; i < lenth; i++) {
            if (!myhashMap.containsKey(String.valueOf(chars[i]))){
                myhashMap.put(String.valueOf(chars[i]),i);
            }else{
                myhashMap.put(String.valueOf(chars[i]),-1);
            }
        }
        int first=lenth;
        for (Map.Entry<String , Integer>entry : myhashMap.entrySet()){
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        if (first == lenth) {
            first = -1;
        }
        return first;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
