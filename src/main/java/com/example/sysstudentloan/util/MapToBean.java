package com.example.sysstudentloan.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MapToBean {
    //将map中的键值对，封装进实体对象属性中
    public static  <T> T mapToBean(HashMap<String, Object> map, Class<T> c){
        //  <T> T     这里不确定返回值类型，写一个泛型类型，作为返回值

        //  HashMap<String, Object> map,Class<T> c
        //  这里在方法中传两个参数，一个是map集合，另一个是实体类，
        //  但是实体类不确定，会一直变动，所以传递一个Class类作为参数类型，可以拿到所有的实体类

        try {
            T t = c.newInstance();      //拿到实体类对象
            //1，拆开map,给对象t的属性赋值
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                Field f = c.getDeclaredField(entry.getKey());
                f.setAccessible(true);  //设置修改权限，因为我们采用的封装private，不修改权限的话，就不能修改实体类中的属性值
                f.set(t,entry.getValue());  //传递参数，第一个为实体类对象，第二个为map集合中的value值
            }
            //2，构建一个实体对象并返回
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("出错啦！"); //将异常放大，可不用写返回值
        }
    }
    /**
     * java生成随机数字和字母组合10位数
     * @param length [生成随机数的长度]
     * @return
     */
    public static String getRandomNickname(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
                val += String.valueOf(random.nextInt(10));
        }
        return val;
    }
}
