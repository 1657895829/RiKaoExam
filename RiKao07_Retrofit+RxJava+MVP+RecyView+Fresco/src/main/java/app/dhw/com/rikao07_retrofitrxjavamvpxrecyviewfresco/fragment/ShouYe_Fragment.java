package app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.R;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.adapter.MyAdapter;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.bean.Bean;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.presenter.MyPresenter;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.view.MyView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 首页Fragment
 */
public class ShouYe_Fragment extends Fragment implements MyView {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private MyAdapter adapter;
    private MyPresenter presenter;

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
        //创建Presenter层实例,与view层交互
        presenter = new MyPresenter(this);

        //get请求方式
//     presenter.get1();   //不传递参数
//     presenter.get2();   //只使用Retrofit的get请求数据,使用@QueryMap注解传递集合参数
        presenter.get();    //使用Retrofit+RxJava的get请求数据,使用@QueryMap注解传递集合参数

        //设置布局管理器以及布局适配器
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        adapter = new MyAdapter(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onSuccess(Bean bean) {
        //请求成功时添加数据,多条目展示
        adapter.addData(bean);
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
        presenter.detach();
    }
}
