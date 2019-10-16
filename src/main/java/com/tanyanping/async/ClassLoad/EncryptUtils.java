package com.tanyanping.async.ClassLoad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**********************************************************************************************
 * @program: async
 * @description: 加密工具类
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-14 22:46
 **********************************************************************************************/
public final class EncryptUtils {

    public static final byte ENCRYPT_FACTOR = (byte) 0xff;

    private EncryptUtils() {
        //empty
    }

    public static void doEncrypt(String source, String target) {
        try (FileInputStream fileInputStream = new FileInputStream(source);
             FileOutputStream fileOutputStream = new FileOutputStream(target);
        ) {
            int len = 0;
            while ((len = fileInputStream.read()) != -1) {
                fileOutputStream.write(len ^ ENCRYPT_FACTOR);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        EncryptUtils.doEncrypt("E:\\thisTest\\com\\tanyanping\\async\\ClassLoad\\MyObjectTest.class","E:\\thisTest\\com\\tanyanping\\async\\ClassLoad\\MyObjectTest.class1");
    }


}
