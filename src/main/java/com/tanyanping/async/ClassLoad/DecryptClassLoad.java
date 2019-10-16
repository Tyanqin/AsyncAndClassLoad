package com.tanyanping.async.ClassLoad;


import java.io.*;

/**********************************************************************************************
 * @program: async
 * @description:
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-14 22:59
 **********************************************************************************************/
public class DecryptClassLoad extends ClassLoader {

    private static final String DEFAULT_DIR = "E:\\thisTest";
    private String dir = DEFAULT_DIR;
    private String classLoadName;

    public DecryptClassLoad() {
        super();
    }

    public DecryptClassLoad(String classLoadName) {
        this.classLoadName = classLoadName;
    }

    public DecryptClassLoad(ClassLoader parent, String classLoadName) {
        super(parent);
        this.classLoadName = classLoadName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = name.replace(".", "/");
        File classFile = new File(dir, className+".class");
        if (!classFile.exists()) {
            throw new ClassNotFoundException("the class " + className + " not found " + dir);
        }
        byte[] classBytes = loadClassByte(classFile);
        if (classBytes == null || classBytes.length == 0) {
            throw new ClassNotFoundException("the class bytes " + name + " is null" + dir);
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);
        //return super.findClass(name);
    }

    private byte[] loadClassByte(File classFile) {
        try (ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
             FileInputStream fileInputStream = new FileInputStream(classFile);
        ) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                byteOutputStream.write(bytes, 0, len);
            }
            byteOutputStream.flush();
            return byteOutputStream.toByteArray();

        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
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


}
