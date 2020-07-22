package vip.kelvin.leetCode;

/**
 * @author Kelvin范显
 * @date 2020/6/19 上午7:25
 */
public class C125_isPalindrome {
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder sgood_rev = new StringBuilder(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }
}
