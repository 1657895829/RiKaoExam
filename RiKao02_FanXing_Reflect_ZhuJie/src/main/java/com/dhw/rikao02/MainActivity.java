package com.dhw.rikao02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 自定义形状类，圆形、方形两个类继承自形状类，
 * 自定义泛型类，只接受形状的子类类型，书写获取形状类型的方法，
 * 自定义注解，修饰形状类，设置注解在运行时生效，
 * 通过反射遍历类中的方法，并使用invoke的方式运行注解的方法.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
