package app.com.fengzhuang.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import app.com.fengzhuang.R;
import app.com.fengzhuang.adapter.MyAdapter;
import app.com.fengzhuang.base.BaseMvpFragment;
import app.com.fengzhuang.bean.Bean;
import app.com.fengzhuang.presenter.MyPresenter;
import app.com.fengzhuang.view.MyView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 首页Fragment,使用XRecyclerView展示数据
 * 继承自定义BaseMvpFragment，持有p与c层
 */
public class ShouYe_Fragment extends BaseMvpFragment<MyView,MyPresenter> implements MyView {
    @BindView(R.id.xRecyclerView)
    XRecyclerView xRecyclerView;
    Unbinder unbinder;
    private MyAdapter adapter;
    private Handler handler = new Handler();
    int num = 0;               //页数

    //声明presenter层,与view层交互
    @Override
    public MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shouye_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //get请求方式
        //p.get1();                           //不传递参数
        p.get2(Integer.toString(num++));   //只使用Retrofit的get请求数据,使用@QueryMap注解传递集合参数
        //p.get();                          //使用Retrofit+RxJava的get请求数据,使用@QueryMap注解传递集合参数

        //设置布局管理器以及布局适配器
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        adapter = new MyAdapter(getActivity());
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
                        //p.get1();
                        p.get2(Integer.toString(num++));
                        //p.get();
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
                        //p.get1();
                        p.get2(Integer.toString(num++));
                        //p.get();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //实现presenter内部的防止内存溢出方法
    @Override
    public void onDestroy() {
        super.onDestroy();
        p.detach();
    }
}
