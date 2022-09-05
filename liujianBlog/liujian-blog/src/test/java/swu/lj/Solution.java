package swu.lj;

class Solution {
    public static void main(String[] args) {
        System.out.println(convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers", 2));
    }
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        char[][] zchar=new char[1000][numRows];
        int x=0;
        int y=0;
        //numRows转换方向的标识
        int j=0;
        //true表示向下走
        Boolean charto=true;
        zchar[0][0]=chars[0];
        StringBuffer result=new StringBuffer();
        for (int i = 1; i < chars.length; i++) {
            if (j==numRows-1){
                charto=!charto;
                j=0;
            }
            if (charto){
                y++;
                zchar[x][y]=chars[i];
                j++;
            }else {
                y--;
                x++;
                zchar[x][y]=chars[i];
                j++;
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int k = 0; k < 1000; k++) {
                if (zchar[k][i]!='\u0000'){
                    result.append(zchar[k][i]);
                }
            }
            System.out.println();
        }
        return result.toString();
    }
}