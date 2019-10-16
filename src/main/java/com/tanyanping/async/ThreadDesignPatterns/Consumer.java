package com.tanyanping.async.ThreadDesignPatterns;

import lombok.extern.log4j.Log4j2;

import java.util.stream.IntStream;

/**********************************************************************************************
 * @program: async
 * @description:   消费者类
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-14 17:48
 **********************************************************************************************/
@Log4j2
public final class Consumer implements Runnable {

    private final ResourceData resourceData;

    public Consumer(ResourceData resourceData) {
        this.resourceData = resourceData;
    }

    @Override
    public void run() {
        IntStream.range(0,100).forEach(i->{
            resourceData.addFirst(new Data(""+i+""));
            log.info(Thread.currentThread().getName()+" ｛生产者生产数据：｝"+i);
        });
    }
}
