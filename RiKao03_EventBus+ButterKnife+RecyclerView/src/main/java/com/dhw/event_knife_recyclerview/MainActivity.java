package com.dhw.event_knife_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.dhw.event_knife_recyclerview.adapter.MyAdapter;
import com.dhw.event_knife_recyclerview.bean.WeiXinBean;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//数据展示页
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycView)
    RecyclerView recycView;
    private MyAdapter adapter;
    private List<WeiXinBean.NewslistBean> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //使用ButterKnife初始化控件
        ButterKnife.bind(this);

        getNetData();

        //getData();
    }

    //使用Okhttp请求网络数据的方法
    public void getData() {
        //使用OKhttp请求网络数据
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.tianapi.com/wxnew/?key=18e883dd6b316eb1d97fd86338abbf06&num=10")
                .build();
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Toast.makeText(MainActivity.this, e + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                final String result = response.body().string();
                System.out.println("返回：" + result);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //成功的回调.运行在子线程中
                        WeiXinBean bean = new Gson().fromJson(result, WeiXinBean.class);
                        list = bean.getNewslist();
                        System.out.println("标题：" + list.get(0).getTitle());

                        //设置布局管理器：recyclerView.setLayoutManager(布局方式)
                        recycView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));

                        //更新ui,适配器添加数据
                        if (adapter == null) {
                            adapter = new MyAdapter(MainActivity.this, list);
                            recycView.setAdapter(adapter);
                        } else {
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        });
    }

    //使用Retrofit封装的方法,请求网络数据
    private void getNetData() {
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com/")    // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create())//设置使用Gson解析(记得加入依赖)
                .build();

        // 创建 网络请求接口 的实例
        GetDataInterface request = retrofit.create(GetDataInterface.class);

        //对 发送请求 进行封装
        Call<WeiXinBean> call = request.getCall();

        //发送网络请求(异步)
        call.enqueue(new Callback<WeiXinBean>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<WeiXinBean> call, Response<WeiXinBean> response) {
                //处理返回的数据结果
                WeiXinBean bean = response.body();
                System.out.println("返回数据："+bean.toString());
                List<WeiXinBean.NewslistBean> list = bean.getNewslist();

                //设置布局管理器：recyclerView.setLayoutManager(布局方式)
                recycView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));

                //更新ui,适配器添加数据
                if (adapter == null) {
                    adapter = new MyAdapter(MainActivity.this, list);
                    recycView.setAdapter(adapter);
                } else {
                    adapter.notifyDataSetChanged();
                }
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<WeiXinBean> call, Throwable t) {
                System.out.println("连接失败");
                Toast.makeText(MainActivity.this, "数据出错：" + t, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
