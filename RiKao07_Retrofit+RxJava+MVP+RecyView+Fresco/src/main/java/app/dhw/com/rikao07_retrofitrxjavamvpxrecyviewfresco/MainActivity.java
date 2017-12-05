package app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.hjm.bottomtabbar.BottomTabBar;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.fragment.Cart_Fragment;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.fragment.FenLei_Fragment;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.fragment.Mine_Fragment;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.fragment.ShouYe_Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

//Fragment页面设置页
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //初始化Fragment
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50, 50)      //图片大小
                .setFontSize(12)                       //字体大小
                .setTabPadding(4, 6, 10)//选项卡的间距
                .setChangeColor(Color.RED, Color.BLUE)     //选项卡的选择颜色
                .addTabItem("首页", R.drawable.home_, ShouYe_Fragment.class)
                .addTabItem("分类", R.drawable.classify, FenLei_Fragment.class)
                .addTabItem("发现", R.drawable.cart, Cart_Fragment.class)
                .addTabItem("我的", R.drawable.mine, Mine_Fragment.class)
                .isShowDivider(true)    //是否包含分割线
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        Log.i("TGA", "位置：" + position + "      选项卡：" + name);
                    }
                });
    }
}
