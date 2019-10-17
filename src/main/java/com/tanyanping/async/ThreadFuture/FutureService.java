package com.tanyanping.async.ThreadFuture;

import java.util.function.Consumer;

/**********************************************************************************************
 * @program: async
 * @description:
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-16 10:12
 **********************************************************************************************/
public class FutureService<T> {

    public Future<T> submit(final FutureTask<T> futureTask, final Consumer<T> consumer1,final Consumer<T> consumer2) throws Exception {
        AsyncFuture asyncFutureTask = new AsyncFuture();
        new Thread(() -> {
            T result = futureTask.call();
            asyncFutureTask.done(result);
            consumer1.andThen(consumer2).accept(result);
        }, "A").start();
        return asyncFutureTask;
    }

}
