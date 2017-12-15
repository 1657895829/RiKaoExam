package app.example.com.property_circleview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * 在onCreat()方法中，首先获取动画资源文件中创建的动画资源，然后获取要应用动画效果的CircleView，
 * 再获取“旋转”按钮，并为该按钮添加单击事件监听器，在重写onClik()方法中，播放动画。
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取动画资源
        final Animation rotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);      //获取旋转动画资源
        final Animation translate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);//获取平移动画资源
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);//获取缩放动画资源
        final Animation alpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);//获取透明度变化动画资源

        //获取要应用动画效果的CircleView
        final CircleView ball =(CircleView)findViewById(R.id.ball);

        Button button1=(Button)findViewById(R.id.button1);//获取"旋转"按钮
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //播放旋转动画
                ball.startAnimation(rotate);
            }
        });
        Button button2=(Button)findViewById(R.id.button2);//获取"平移"按钮
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //播放平移动画
                ball.startAnimation(translate);

            }
        });
        Button button3=(Button)findViewById(R.id.button3);//获取"缩放"按钮
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //播放缩放动画
                ball.startAnimation(scale);

            }
        });
        Button button4=(Button)findViewById(R.id.button4);//获取"透明度渐变"按钮
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //播放透明度渐变动画
                ball.startAnimation(alpha);

            }
        });
        Button value=(Button)findViewById(R.id.value);//获取"ValueAnimator "按钮
        value.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //播放ValueAnimator 动画 实现小球从屏幕左边移动到右边缘
                doAnimation(ball);
            }
        });
        Button object=(Button)findViewById(R.id.object);//获取"ObjectAnimator"按钮
        object.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //播放ObjectAnimator 组合动画
                setAnimation(ball);
            }
        });

    }

    //ValueAnimator 动画
    private void doAnimation(final CircleView ball){
        //运动轨迹是从屏幕的左上角(0,0)点运行到（600，600）点。
        ValueAnimator animator = ValueAnimator.ofInt(0,600);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                //小球的运动轨迹
                ball.layout(curValue,curValue,curValue+ball.getWidth(),curValue+ball.getHeight());
            }
        });
        animator.start();
    }

    /*
       执行组合动画的方法
       组合动画，小球闪烁的同时，从屏幕左上角，以抛物线轨迹（贝赛尔曲线）移动到右下角
     */
    private void setAnimation(CircleView ball) {
        //闪烁
        ObjectAnimator alpha = ObjectAnimator.ofFloat(ball, "alpha", 1f, 0f, 1f);
        alpha.setDuration(2000);
        alpha.start();

        //平移
        ObjectAnimator trans1 = ObjectAnimator.ofFloat(ball,  "translationX", 0f, 600f);
        trans1.setDuration(2000);
        trans1.start();
        ObjectAnimator trans2 = ObjectAnimator.ofFloat(ball, "translationY", 0f, 1000f);
        trans2.setDuration(2000);
        trans2.start();
    }

}