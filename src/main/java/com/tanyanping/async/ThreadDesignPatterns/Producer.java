package com.tanyanping.async.ThreadDesignPatterns;

import lombok.extern.log4j.Log4j2;

import java.util.stream.IntStream;

/**********************************************************************************************
 * @program: async
 * @description:   生产者类
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-14 17:52
 **********************************************************************************************/
@Log4j2
public final class Producer implements Runnable {

    private final  ResourceData resourceData;

    public Producer(ResourceData resourceData) {
        this.resourceData = resourceData;
    }

    @Override
    public void run() {
        IntStream.range(0,100).forEach(
                i->{
                    resourceData.removeData();
                    log.info(Thread.currentThread().getName()+" ｛消费者消费数据：｝"+i);
                });
    }
}
