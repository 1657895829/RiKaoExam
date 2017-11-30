package com.dhw.event_knife_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import butterknife.BindView;
import butterknife.ButterKnife;

//EventBus的传值通信接收页
public class SecondActivity extends AppCompatActivity {
    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        //初始化EventBus,注册EventBus，订阅黏性事件
        EventBus.getDefault().register(this);
    }

    //主线程UI，注册粘性订阅事件，黏性事件处理函数
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true) //这种写法达到粘性的目的
    public void receiveSticky(EventBusSticky eventBusSticky){
        Toast.makeText(SecondActivity.this,"处理订阅粘性事件，接收数据",Toast.LENGTH_SHORT).show();
        text.setText(eventBusSticky.string);
    }

    //在onDestory()方法中取消订阅：防止内存溢出
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }
}
