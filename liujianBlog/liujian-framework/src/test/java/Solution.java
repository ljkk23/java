class Solution {
    public static void main(String[] args) {
        String cbbd = longestPalindrome("cbbd");
        System.out.println(cbbd);
    }
    public static String longestPalindrome(String s) {
        int len=s.length();
        Boolean[][] dp=new Boolean[len][len];
        char[] chars = s.toCharArray();
        for (int i=0;i<len;i++){
            dp[i][i]=true;
        }
        if (len==1) {
            return s;
        } else if (len==2) {
            if (chars[0]==chars[1]){
                return s;
            }
        }
        int maxLenth=0;
        int begin=0;
        //这里一定要注意，要先确定列的值，因为如果chars[i]==char[j],就会状态转移到char[i+1]和char[j-1],所以必须有char[i+1]和char[j-1]的判断，所以就应该有列的数据
        for (int j = 1; j < len; j++) {
            //又因为只需要判断对角线上面的值，所以i<j
            for (int i = 0; i < j; i++) {
                if (chars[i]!=chars[j]){
                    dp[i][j]=false;
                }else {
                        if (j - i < 3) {
                            dp[i][j]=true;
                        }else {
                            dp[i][j]=dp[i+1][j-1];
                        }
                }
                if (dp[i][j] && maxLenth < j + 1 - i) {
                    maxLenth = j + 1 - i;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLenth);
    }
}