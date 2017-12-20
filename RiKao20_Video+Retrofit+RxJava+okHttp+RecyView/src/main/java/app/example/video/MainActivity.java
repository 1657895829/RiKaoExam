package app.example.video;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import app.example.video.adapter.MyAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 视频播放以及数据展示页面
 * 权限必不可少：
 * <uses-permission android:name="android.permission.INTERNET"/>
 * <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"></uses-permission>
 * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
 * <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    PlayerView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //设置RecyclerView展示数据的布局管理器以及适配器
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        MyAdapter adapter = new MyAdapter(MainActivity.this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        //加载视频接口URL，播放视频
        play = new PlayerView(this)
                .setTitle("什么")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource("http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4");
        play.startPlay();
    }

    @OnClick(R.id.jiagou_btn)
    public void onViewClicked() {
        Toast.makeText(this, "结果：加入购物车成功", Toast.LENGTH_LONG).show();
    }

    /**
     * onWindowsFocusChanged()就是指当前的Activity的Windows(窗口)获取或者失去焦点时这个方法就会被调用，
     * 并且当回调这个方法时，Activity是完全可见的。在onResume()方法后面调用；
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    //退出时销毁资源，停止播放
    @Override
    protected void onStop() {
        super.onStop();
        play.stopPlay();
    }
}
