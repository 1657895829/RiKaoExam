package com.dhw.rikao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.dhw.rikao.adapter.MyAdapter;
import com.dhw.rikao.bean.WeiXinBean;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//加载适配器页面
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.listView)
    ListView listView;
    private MyAdapter adapter;
    private List<WeiXinBean.NewslistBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getData();

        //点击条目跳转至网页加载页面
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //获取url路径跳转传值
                String url = list.get(i).getUrl();
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }

    //请求网络数据的方法
    public void getData() {
        //使用OKhttp请求网络数据
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.tianapi.com/wxnew/?key=18e883dd6b316eb1d97fd86338abbf06&num=10")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(MainActivity.this, e + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                System.out.println("返回：" + result);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //成功的回调.运行在子线程中
                        WeiXinBean bean = new Gson().fromJson(result, WeiXinBean.class);
                        list = bean.getNewslist();
                        System.out.println("标题：" + list.get(0).getTitle());

                        //更新ui,适配器添加数据
                        if (adapter == null) {
                            adapter = new MyAdapter(MainActivity.this, list);
                            listView.setAdapter(adapter);
                        } else {
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        });
    }
}
