package com.tanyanping.async.ThreadDesignPatterns;

import lombok.extern.log4j.Log4j2;

import java.util.LinkedList;

/**********************************************************************************************
 * @program: async
 * @description:    操作的同一数据源
 * @author: TanYanQing
 * @email: 449330962@qq.com
 * @create: 2019-10-14 17:13
 **********************************************************************************************/
@Log4j2
public final class ResourceData {

         private final LinkedList<Data> linkedList = new LinkedList<Data>();

         private int size = 10;

         public ResourceData(int size){
                  this.size = size;
         }

         public synchronized void addFirst(Data data){
              while (linkedList.size() > size ){
                  try {
                      this.wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
              linkedList.addFirst(data);
              this.notifyAll();
         }


         public synchronized void removeData(){
                   while(linkedList.size() <= 0){
                       try {
                           this.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                   linkedList.removeFirst();
                   this.notifyAll();
         }





}
