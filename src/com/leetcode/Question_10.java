package com.leetcode;

/**
 * 
 * @author fangji
 * 
 * 题目：https://leetcode-cn.com/problems/regular-expression-matching/description/
 * 示例1：
 * 示例2：
 * 示例3：
 * 示例4：
 * 
 * 解题思路：
 * 
 * 参考资料：http://blog.sina.com.cn/s/blog_14e300ff50102xrzk.html
 * 	
 */
public class Question_10 {
	public boolean isMatch(String s, String p) {
		//p匹配结束，观察s是否也结束
        if(p.length() == 0)
            return s.length() == 0;

        //p下一个字符不存在连续匹配情况*，直接进行比较，并递归到第二项之后的子串
        if(p.length() == 1 || p.charAt(1) != '*')
        {
            if(s.length() != 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'))
                return isMatch(s.substring(1), p.substring(1));
            else
                return false;
        }

        //p下一个字符存在连续匹配情况*，比较首项，并且递归进行比较
        while(s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
        {
            if(isMatch(s, p.substring(2)))
                return true;
            s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
    }
	
	public static void main(String[] args) {
		String s = "ab";
		String p = ".*";
		System.out.println("isMatch = " + new Question_10().isMatch(s, p));
	}
}
