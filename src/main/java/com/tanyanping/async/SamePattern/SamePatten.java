package com.tanyanping.async.SamePattern;

import java.util.Collections;
import java.util.List;

/**********************************************************************************************
 * @program: AsyncAndClassLoad
 * @description: 关于不变模式，可以参考java.lang.String类的源代码。
 * 不变模式应该遵循  变量用final修饰、类用final修饰。所有变量只提供get方法。
 * 返回值应该返回新的对象。
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-17 15:48
 **********************************************************************************************/
public final class SamePatten {

    private final String name;

    private final Integer age;

    private final List<String> list;

    final Object object = new Object();

    public SamePatten(String name, Integer age, List<String> list) {
        synchronized (object) {
            this.name = name;
            this.age = age;
            this.list = list;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);   //返回不可变集合。
    }
}
