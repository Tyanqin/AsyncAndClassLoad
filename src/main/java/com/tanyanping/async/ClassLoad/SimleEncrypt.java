package com.tanyanping.async.ClassLoad;

/**********************************************************************************************
 * @program: async
 * @description: 加密工具测试类
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-14 22:35
 **********************************************************************************************/
public class SimleEncrypt {

    public static void main(String args[]) {

        String param = "123456";
        byte factor = (byte) 0xff;

        byte[] bytes = param.getBytes();
        byte[] bytes1 = new byte[bytes.length];

        for (int i = 0; i < bytes.length; i++) {
            bytes1[i] = (byte) (bytes[i] ^ factor);
        }
        System.out.println(new String(bytes1));


        byte[] bytes2 = new byte[bytes.length];
        for (int i = 0; i < bytes1.length; i++) {
            bytes2[i] = (byte) (bytes1[i] ^ factor);
        }
        System.out.println(new String(bytes2));


    }

}
