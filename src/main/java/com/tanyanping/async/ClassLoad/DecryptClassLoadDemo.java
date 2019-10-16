package com.tanyanping.async.ClassLoad;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**********************************************************************************************
 * @program: async
 * @description:
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-15 16:27
 **********************************************************************************************/
public class DecryptClassLoadDemo extends ClassLoader {

    private static final String DEFAULT_DIR = "E:\\thisTest";

    private String classLoadName;

    private String dir;


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = name.replace(".", "/");
        File classFile = new File(dir, className + ".class");
        if (!classFile.exists()) {
            throw new ClassNotFoundException("not fount class  " + dir + "\\" + className);
        }
        byte[] bytes = loadClassByte(classFile);
        if (bytes == null || bytes.length == 0) {
            throw new ClassNotFoundException("the class bytes is null  " + dir + "\\" + className);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassByte(File classFile) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             FileInputStream fileInputStream = new FileInputStream(classFile);
        ) {
            int len;
            while ((len = fileInputStream.read()) != -1) {
                byteArrayOutputStream.write(len ^ EncryptUtils.ENCRYPT_FACTOR);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            return null;
        }

    }

    public DecryptClassLoadDemo() {
        super();
    }

    public DecryptClassLoadDemo(String classLoadName, ClassLoader classLoader) {
        super(classLoader);
        this.classLoadName = classLoadName;
    }

    public DecryptClassLoadDemo(String classLoadName) {
        this.classLoadName = classLoadName;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getClassLoadName() {
        return classLoadName;
    }

    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        DecryptClassLoadDemo decryptClassLoadDemo1 = new DecryptClassLoadDemo("this is a custom1 ");
        decryptClassLoadDemo1.setDir("E:\\thisTest");
        Class<?> clazz = decryptClassLoadDemo1.loadClass("com.tanyanping.async.ClassLoad.MyObjectTest");
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("HelloWorld", new Class<?>[]{});
        System.out.println(method.invoke(obj, new Class<?>[]{}));
    }


}
