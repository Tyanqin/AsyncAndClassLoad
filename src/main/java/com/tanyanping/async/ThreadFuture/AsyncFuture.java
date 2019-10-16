package com.tanyanping.async.ThreadFuture;

/**********************************************************************************************
 * @program: async
 * @description:
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-16 10:14
 **********************************************************************************************/
public class AsyncFuture<T> implements Future<T> {

    private volatile boolean flag = false;

    private T result;

    public synchronized void done(T result) {
        this.result = result;
        this.flag = true;
        this.notifyAll();
    }

    @Override
    public synchronized T get() throws Exception {
        while (!flag) {
            this.wait();
        }
        return this.result;
    }
}
