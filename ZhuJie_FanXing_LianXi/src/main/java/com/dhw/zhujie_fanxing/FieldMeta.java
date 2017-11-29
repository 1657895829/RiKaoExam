package com.dhw.zhujie_fanxing;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * java自定义注解
    Java注解是附加在代码中的一些元信息，用于一些工具在编译、运行时进行解析和使用，起到说明、配置的功能。
    注解不会也不能影响代码的实际逻辑，仅仅起到辅助性的作用。包含在 java.lang.annotation 包中。

   1、元注解
      元注解是指注解的注解。包括  @Retention @Target @Document @Inherited四种。
  1.1、@Retention: 定义注解的保留策略

     @Retention(RetentionPolicy.SOURCE)     //注解仅存在于源码中，在class字节码文件中不包含
     @Retention(RetentionPolicy.CLASS)     // 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得，
     @Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
 */

@Retention(RetentionPolicy.RUNTIME)             // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target({ElementType.FIELD,ElementType.METHOD})//定义注解的作用目标**作用范围字段、枚举的常量/方法
@Documented//说明该注解将被包含在javadoc中

//注解类
public @interface FieldMeta {
    /**
     * 是否为序列号
     * @return
     */
    boolean id() default  false;

    /**
     * 字段名称
     * @return
     */
    String name() default "";

    /**
     * 是否可编辑
     * @return
     */
    boolean editable() default true;

    /**
     * 是否在列表中显示
     * @return
     */
    boolean summary() default true;

    /**
     * 字段描述
     * @return
     */
    String description() default "";

    /**
     * 排序字段
     * @return
     */
    int order() default 0;
}

