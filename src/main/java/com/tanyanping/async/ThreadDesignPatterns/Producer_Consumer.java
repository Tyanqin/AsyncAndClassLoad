package com.tanyanping.async.ThreadDesignPatterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**********************************************************************************************
 * @program: async
 * @description:   生产者与消费者线程
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-14 17:12
 **********************************************************************************************/
public class Producer_Consumer {

    public static void main(String args[]) {
        ResourceData resourceData = new ResourceData(10);
        Consumer consumer = new Consumer(resourceData);
        Producer producer = new Producer(resourceData);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(producer);
        executorService.submit(consumer);
        executorService.submit(producer);
        executorService.shutdownNow();
    }

}



