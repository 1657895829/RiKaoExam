package app.com.rikao10;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ExpandableListView;
import java.util.List;
import app.com.rikao10.adapter.FenLei_Left_Adapter;
import app.com.rikao10.adapter.FenLei_Right_Adapter;
import app.com.rikao10.app.DividerGridltemDecoration;
import app.com.rikao10.bean.ChildBean;
import app.com.rikao10.bean.LeftBean;
import app.com.rikao10.bean.RightBean;
import app.com.rikao10.presenter.FenLeiPresenter;
import app.com.rikao10.view.FenLeiView;
import butterknife.BindView;
import butterknife.ButterKnife;

//分类页面UI布局
public class MainActivity extends AppCompatActivity implements FenLeiView {
    @BindView(R.id.fl_zuorv)
    RecyclerView flZuorv;
    @BindView(R.id.fl_yourv)
    ExpandableListView flYourv;
    private FenLeiPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //实例化P层,调用方法，显示数据
        presenter = new FenLeiPresenter(this);
        presenter.getRightData(1);
        presenter.getLeftData();
    }

    @Override
    public void ShowLeftData(final List<LeftBean.DataBean> leftList) {
        //设置左边数据线性布局管理器以及适配器
        flZuorv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        FenLei_Left_Adapter leftAdapter = new FenLei_Left_Adapter(MainActivity.this, leftList);
        flZuorv.setAdapter(leftAdapter);

        //分割线
        flZuorv.addItemDecoration(new DividerGridltemDecoration(MainActivity.this));

        //回调调用条目点击事件
        leftAdapter.setOnItemClickListener(new FenLei_Left_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //设置数据页数
                int cid = leftList.get(position).getCid();
                presenter.getRightData(cid);
            }
        });

    }

    @Override
    public void ShowRightData(List<RightBean.DataBean> rightList) {
        //设置右边数据线性布局管理器以及适配器
        FenLei_Right_Adapter rightAdapter = new FenLei_Right_Adapter(MainActivity.this, rightList);
        flYourv.setAdapter(rightAdapter);

        //父级列表默认全部展开
        int count = flYourv.getCount();
        for (int i = 0;i<count;i++){
            flYourv.expandGroup(i);
        }
    }

    @Override
    public void ShowChildData(List<ChildBean.DataBean> childList) {
    }

    //重写p层解绑的方法，防止内存泄露
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
