package com.first.group.comment;

public class ThreadLocalUtils {

    private final static ThreadLocal<Object> userThreadLocal = new ThreadLocal<>();

    /**
     * 设置数据到当前线程
     */
    public static void set(Object o){
        userThreadLocal.set(o);
    }

    /**
     * 获取线程中的数据
     * @return
     */
    public static Object get( ){
        return userThreadLocal.get();
    }

    /**
     * 删除线程中的数据
     */
    public static void remove(){
        userThreadLocal.remove();
    }
}