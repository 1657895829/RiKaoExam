package com.dhw.greendao_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.dhw.greendao_retrofit.bean.NewsBean;
import com.dhw.greendao_retrofit.bean.NewslistBean;
import com.dhw.greendao_retrofit.bean.User;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//数据库内容显示主页
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.edit_id)
    EditText editId;
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.delete)
    Button delete;
    @BindView(R.id.select)
    Button select;
    @BindView(R.id.result)
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getNetData();
    }

    @OnClick({R.id.insert, R.id.delete, R.id.select})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.insert:   //添加数据
                if (TextUtils.isEmpty(editId.getText().toString()) || TextUtils.isEmpty(editName.getText().toString())){
                    Toast.makeText(MainActivity.this, "用户名或id不能为空！", Toast.LENGTH_SHORT).show();
                }else {
                    //把输入的不为空内容封装为user对象
                    User user = new User(Long.valueOf(editId.getText().toString()), editName.getText().toString());
                    //User user = new User(12112L, "123132123");

                    //通过IApplication.session添加输入数据到数据库
                    IApplication.session.getUserDao().insert(user);

                    Toast.makeText(MainActivity.this, "数据插入成功！", Toast.LENGTH_SHORT).show();

                    //添加完查询一下  loadAll()查询数据库全部内容
                    List<User> users = IApplication.session.getUserDao().loadAll();
                    for (User data : users){
                        System.out.println("User数据 = " + data.toString());
                    }
                }

                break;

            case R.id.delete:  //删除数据

                if (TextUtils.isEmpty(editId.getText().toString()) || TextUtils.isEmpty(editName.getText().toString())){
                    Toast.makeText(MainActivity.this, "用户名或id不能为空！", Toast.LENGTH_SHORT).show();
                }else {
                    //通过IApplication.session删除数据
                    IApplication.session.getUserDao().deleteByKey(Long.valueOf(editId.getText().toString()));

                    Toast.makeText(MainActivity.this, "数据删除成功！", Toast.LENGTH_SHORT).show();

                    System.out.println("删除id数据 = " + Long.valueOf(editId.getText().toString()));

                    //删除完查询一下  loadAll()查询数据库全部内容
                    List<User> users = IApplication.session.getUserDao().loadAll();
                    for (User data : users){
                        System.out.println("删除后User数据 = " + data.toString());
                    }
                }
                break;

            case R.id.select:  //查询数据
                if (TextUtils.isEmpty(editId.getText().toString()) || TextUtils.isEmpty(editName.getText().toString())){
                    Toast.makeText(MainActivity.this, "用户名或id不能为空！", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "数据查询成功！", Toast.LENGTH_SHORT).show();

                    // loadAll()查询数据库全部内容
                    List<User> users = IApplication.session.getUserDao().loadAll();
                    for (User data : users){
                        System.out.println("查询User数据 = " + data.toString());
                    }
                    result.setText(users.toString());
                }
                break;

        }
    }

    //使用Retrofit对象请求数据的方法
    public  void getNetData(){
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com")// 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create())//设置使用Gson解析(记得加入依赖)
                .build();

        //创建 网络请求接口 的实例
        GetDataInterface request = retrofit.create(GetDataInterface.class);

        //对 发送请求 进行封装
        Call<NewsBean> call = request.getData();

        //发送网络请求(异步)
        call.enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                //返回的数据
                NewsBean newsBean = response.body();

                //通过IApplication.session操作数据库  //insertInIx 将集合添加到数据库
                IApplication.session.getNewslistBeanDao().insertInTx(newsBean.getNewslist());

                //添加完查询一下  loadAll()查询数据库全部内容
                List<NewslistBean> list = IApplication.session.getNewslistBeanDao().loadAll();
                for (NewslistBean bean : list){
                    System.out.println("查询数据 = " + bean.toString());
                }
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {

            }
        });

    }
}
