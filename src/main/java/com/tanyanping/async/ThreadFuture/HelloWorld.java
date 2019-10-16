package com.tanyanping.async.ThreadFuture;

/**********************************************************************************************
 * @program: async
 * @description:
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-16 10:47
 **********************************************************************************************/
public class HelloWorld implements FutureTask<String> {

    @Override
    public String call()  {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello World";
    }


    public static void main(String args[]) throws Exception {
        FutureService<String> futureService = new FutureService<>();
        HelloWorld helloWorld = new HelloWorld();
        Future<String> future = futureService.submit(helloWorld,(message)->{
                 System.out.println(message);
        });
        System.out.println("==========================================================");
        //System.out.println(future.get());
    }
}
