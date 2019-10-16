package com.tanyanping.async.ThreadFuture;

/**********************************************************************************************
 * @program: async
 * @description:
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-16 10:09
 **********************************************************************************************/
public interface Future<T> {

    T get() throws Exception;


}
