package com.caiyunlin;

public class Problem5 implements Problem {

    /*
    最长回文数：
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    示例 1：
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    示例 2：
    输入: "cbbd"
    输出: "bb"
    */


    @Override
    public void Run() {

        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println("longest palindrome of " + s + " is " + result);

        s = "cbbd";
        result = longestPalindrome(s);
        System.out.println("longest palindrome of " + s + " is " + result);

        s = "aa";
        result = longestPalindrome(s);
        System.out.println("longest palindrome of " + s + " is " + result);

        s = "daomdukomcayjwgmmetypncdeixarhbectjcwftjjtwjrctixtrsehegwlfotpljeeqhntacfihecdjysgfmxxbjfeskvvfqdoedfxriujnoeteleftsjgdsagqvcgcdjbxgmguunhbjxyajutohgbdwqtjghdftpvidkbftqbpeahxbfyamonazvubzirhqseetaneptnpjbtrtitttxsyjckjvwtrmuwgidkofvobrwrffzrpnxbectsydbvswstfiqranjzhsebjnmprjoirqkgttahrivkcjtitdcpohwwerwgrdivqbltfnigavydxpmitttjjzyrmpaptkczzgnsovebvxezkkovgqegctxacvjfqwtiycnhartzczcgosiquhmdbljjzyrnmffcwnkyzytnsvyzayrieqyrfpxintbbiyrawxlguzaisedwabpzvevlejadztuclcpwvonehkhknicdksdcnjfaoeaqhcdkdtywilwewadcnaprcasccdcnvdgjdqirrsqwzhqqorlhbgpelpupdvuynzybcqkffnnpocidkkigimsa";
        result = longestPalindrome(s);
        System.out.println("longest palindrome of " + s + " is " + result);

    }

    //O(n^3)，找寻所有子串，然后判断子串是否是回文，这个算法是暴力算法，效率最低
    private String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        String tempString ;
        String tempResult = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                //JAVA substring; beginIndex, endIndex(不包括)
                tempString = s.substring(i, j);
                if (isPalindrome(tempString)) {
                    if (tempString.length() > tempResult.length()) {
                        tempResult = tempString;
                    }
                }
            }
        }
        return tempResult;
    }

    private boolean isPalindrome(String s) {
        boolean result = true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                result = false;
                left = right;
            }
            left++;
            right--;
        }
        return result;
    }

    //参考Manacher算法 https://www.cnblogs.com/z360/p/6375514.html (马拉车算法)
}
