package DBUtil;


import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FormattoJudge {
    public static void main(String[] args) {
//        String a="我是张润民";
//        String b="wo是张润民";
//        String c="wowo";
//        String d="SSSdkdkd444";
//        String e="555dddd####";
//        String f="ddd等等";
//        System.out.println(checkNameChese(a));
//        System.out.println(checkNameChese(b));
//        System.out.println(checkNameChese(c));
//        System.out.println(isLetterOrDigits(d));
//        System.out.println(isLetterOrDigits(e));
//        System.out.println(isLetterOrDigits(f));


        String a="12312";
        String b="fadfa";
        String c="e123";
        System.out.println(isNum(a));
        System.out.println(isNum(b));
        System.out.println(isNum(c));
    }

    public static boolean isLetterOrDigits(String string) {
        boolean flag = false;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLowerCase(string.charAt(i))
                    || Character.isUpperCase(string.charAt(i))
                    || Character.isDigit(string.charAt(i))) {
                flag = true;
            } else {
                flag = false;
                return flag;
            }
        }
        return flag;

    }
    //判断字符是否是汉字
    public static boolean isChineseChar(char c) {
        try {
            return String.valueOf(c).getBytes("UTF-8").length > 1;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 验证字符串内容是否包含下列非法字符<br>
     * `~!#%^&*=+\\|{};:'\",<>/?○●★☆☉♀♂※¤╬の〆
     *
     * @param content   字符串内容
     * @return 't'代表不包含非法字符，otherwise代表包含非法字符。
     */

    public static char validateLegalString(String content) {
        String illegal = "`~!#%^&*=+\\|{};:'\",<>/?○●★☆☉♀♂※¤╬の〆";
        char isLegalChar = 't';
        Code1: for (int i = 0; i < content.length(); i++) {//L1定义代码块L1
            for (int j = 0; j < illegal.length(); j++) {
                if (content.charAt(i) == illegal.charAt(j)) {
                    isLegalChar = content.charAt(i);
                    break Code1;
                }
            }
        }
        return isLegalChar;
    }

    /**
     * 校验某个字符是否是a-z、A-Z、_、0-9
     *
     * @param c
     *      被校验的字符
     * @return true代表符合条件
     */
    public static boolean isWord(char c) {
        String regEx = "[\\w]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher("" + c);
        return m.matches();
    }


    /**
     * 校验String是否全是中文
     *
     * @param name
     *      被校验的字符串
     * @return true代表全是汉字
     */
    public static boolean checkNameChese(String name) {
        boolean res = true;
        char[] cTemp = name.toCharArray();//转换为数组
        for (int i = 0; i < name.length(); i++) {
            if (!isChinese(cTemp[i])) {//逐个判断是否为中文
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * 判定输入的是否是汉字
     *
     * @param c
     *      被校验的字符
     * @return true代表是汉字
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }


    //判断字符串是否是数字
    public static boolean isNum(String a){
        return StringUtils.isNumeric(a);
    }
}
