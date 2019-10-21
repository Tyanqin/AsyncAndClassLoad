package com.tanyanping.async.AtomicTest;

import sun.misc.Unsafe;

/**********************************************************************************************
 * @program: AsyncAndClassLoad
 * @description:
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-21 10:08
 **********************************************************************************************/
public class AtomicInteger {

    public static void main(String args[]) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(0);
        boolean flag = atomicInteger.compareAndSet(0, 1);
        System.out.println(flag);
        int result = atomicInteger.getAndIncrement();
        System.out.println(result);
        int result1 = atomicInteger.getAndDecrement();
        System.out.println(result1);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.addAndGet(123));
        Unsafe unsafe = Unsafe.getUnsafe();


    }


}
