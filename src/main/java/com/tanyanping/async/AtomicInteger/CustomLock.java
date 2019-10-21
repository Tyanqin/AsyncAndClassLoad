package com.tanyanping.async.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

/**********************************************************************************************
 * @program: AsyncAndClassLoad
 * @description:
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-17 17:16
 **********************************************************************************************/
public class CustomLock {

    final AtomicInteger atomicInteger = new AtomicInteger(0);

    private Thread thread;

    public void lock() throws LockException {
        boolean flag = atomicInteger.compareAndSet(0, 1);
        if (!flag) {
          throw new LockException("this is a lockException");
        }
       thread = Thread.currentThread();
    }

    public void unlock() {
        if (atomicInteger.get() == 0) {
            return;
        }
        if (thread == Thread.currentThread()) {
            atomicInteger.compareAndSet(1,0);
        }
    }


}
