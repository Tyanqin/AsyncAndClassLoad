package com.tanyanping.async.AtomicInteger;

/**********************************************************************************************
 * @program: AsyncAndClassLoad
 * @description:
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-17 18:02
 **********************************************************************************************/
public class Test {

    public static void main(String args[]) {

        final CustomLock customLock = new CustomLock();
        new Thread(()->{
            try {
                customLock.lock();
            } catch (LockException e) {
                e.printStackTrace();
            }finally {
                customLock.unlock();
            }

        },"A");
        new Thread(()->{
            try {
                customLock.lock();
            } catch (LockException e) {
                e.printStackTrace();
            }finally {
                customLock.unlock();
            }

        },"B");

    }
}
