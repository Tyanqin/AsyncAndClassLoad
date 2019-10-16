package com.tanyanping.async.ClassLoad;

import lombok.extern.log4j.Log4j2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**********************************************************************************************
 * @program: async
 * @description:
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-14 22:15
 **********************************************************************************************/
@Log4j2
public class MyClassLoadTest {

    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        DecryptClassLoad decryptClassLoad = new DecryptClassLoad("this is first class load");
        Class<?> clazz = decryptClassLoad.loadClass("com.tanyanping.async.ClassLoad.MyObjectTest");
        Object object = clazz.newInstance();
        log.info("{ "+clazz.getClassLoader()+"  }");
        Method method = clazz.getMethod("HelloWorld", new Class[]{});
        System.out.println(method.invoke(object, new Class[]{}));
    }


}
