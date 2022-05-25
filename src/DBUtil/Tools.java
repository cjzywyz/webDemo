package DBUtil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author kj
 * @date 2022/5/11
 * @apiNote
 */
public class Tools {
    public static String Md5(String data) {
        String vOut ="";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");//得到加密类的对象
            byte[] input = data.getBytes();//得到明文的字节数组

            md.update(input);//更新摘要数据

            byte[] output = md.digest();//计算哈希码
            BigInteger value = new BigInteger(1,output);//将哈希码转换为大整数
            vOut = value.toString(16);//将大整数转换为16进制字符串
            return vOut;//返回字符串

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
