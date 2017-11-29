package com.dhw.rikao02;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义圆形类继承自形状类
 */

public class Circle<T> extends Shape {
    public T circle ;

    public List<Shape> list = new ArrayList<>();

    public void add(Shape<? extends T> shape){
        list.add(shape);
    }


    @User
    public void testAnnotation(){


    }
}
