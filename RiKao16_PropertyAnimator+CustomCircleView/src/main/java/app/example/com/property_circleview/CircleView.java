package app.example.com.property_circleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义圆形小球view
 */
public class CircleView extends View {
    private Paint paint;

    /**
     * java代码创建时调用
     * @param context
     */
    public CircleView(Context context) {
        super(context);
        init();
    }

    /**
     * xml创建时调用
     * @param context
     * @param attrs
     */
    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 有style资源文件时调用
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //初始化画笔数据
    public void init(){
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
    }

    /**
     * 实现onDraw()方法实现绘图操作 使用画笔绘制圆为小球
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //x :圆心的x坐标
        //y :圆心的y坐标
        //radius ：圆的半径
        //paint ：画笔
        canvas.drawCircle(50,50,50,paint);
    }
}
