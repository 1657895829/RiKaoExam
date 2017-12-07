package app.com.rika09;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import app.com.rika09.adapter.MyAdapter;
import app.com.rika09.base.BaseMvpActivity;
import app.com.rika09.bean.Bean;
import app.com.rika09.presenter.MyPresenter;
import app.com.rika09.view.MyView;
import butterknife.BindView;
import butterknife.ButterKnife;

//MainActivity类，继承自定义的BaseMvpActivity，持有v与p层
public class MainActivity extends BaseMvpActivity<MyView, MyPresenter> implements MyView {
    @BindView(R.id.xRecyclerView)
    XRecyclerView xRecyclerView;
    private MyAdapter adapter;
    private Handler handler = new Handler();

    //声明p层
    @Override
    public MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        p.get();    //get请求方式获取数据

        //设置布局管理器以及布局适配器
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        adapter = new MyAdapter(MainActivity.this);
        xRecyclerView.setLayoutManager(manager);
        xRecyclerView.setAdapter(adapter);

        //XRecyclerview的上拉下拉方法
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /**
                         * 在子线程内完成上拉刷新数据
                         * 对于本接口来说，只要你把p层请求数据的方法再写一遍重新请求数据，数据就会刷新，即使你不传递页数参数
                         */
                        p.get();
                        adapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();
                    }
                },888);
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /**
                         *    在子线程内完成下拉加载数据
                         *    对于本接口来说，只要你把p层请求数据的方法再写一遍重新请求数据，数据就会加载，即使你不传递页数参数
                         */
                        p.get();
                        adapter.notifyDataSetChanged();
                        xRecyclerView.loadMoreComplete();
                    }
                },888);
            }
        });

    }

    @Override
    public void onSuccess(Bean bean) {
        //请求成功时添加数据,多条目展示
        adapter.addData(bean);
        System.out.println("解析：" + bean.getNewslist().toString());
    }

    @Override
    public void onFailure(Exception e) {
        System.out.println("数据出错：" + e);
    }

    //实现presenter内部的防止内存溢出方法
    @Override
    public void onDestroy() {
        super.onDestroy();
        p.detach();
    }
}
