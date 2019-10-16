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

    public Future<T> submit(final FutureTask<T> futureTask, final Consumer<T> consumer) throws Exception {
        AsyncFuture asyncFutureTask = new AsyncFuture();
        new Thread(() -> {
            T result = futureTask.call();
            asyncFutureTask.done(result);
            consumer.accept(result);
        }, "A").start();
        return asyncFutureTask;
    }

}
