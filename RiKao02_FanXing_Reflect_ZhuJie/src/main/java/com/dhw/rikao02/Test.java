package com.dhw.rikao02;

import java.lang.reflect.Method;

/**
 * 通过反射遍历类中的方法，并使用invoke的方式运行注解的方法
 */
public class Test {
    public static void main(String [] args){

        try {
            //通过反射获取自定义圆形类，创建单例模式
            Class clazz =  Class.forName("com.dhw.rikao02.Circle");
            Circle circle = (Circle) clazz.newInstance() ;

            //获取所有方法
            Method[] methods =  clazz.getDeclaredMethods() ;

            //通过反射遍历所有方法
            for(Method method : methods){
                //如果遍历的方法含有指定的User类注解
                if(method.isAnnotationPresent(User.class)){
                    User user = method.getAnnotation(User.class);
                    method.setAccessible(true);
                    //使用invoke的方式运行注解的方法
                    method.invoke(circle);
                    System.out.println("method："+method.invoke(circle));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

