package com.tanyanping.async.AtomicInteger;

/**********************************************************************************************
 * @program: AsyncAndClassLoad
 * @description:
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-17 17:57
 **********************************************************************************************/
public class LockException  extends Exception {

    private String message;

    public LockException(String message){
           this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
