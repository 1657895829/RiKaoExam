package app.com.rikao13;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import app.com.rikao13.bean.LoginBean;
import app.com.rikao13.presenter.LoginPresenter;
import app.com.rikao13.shared.SharedUtils;
import app.com.rikao13.view.MyView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//用户登录
public class LoginActivity extends AppCompatActivity implements MyView.LoginView {
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.reg)
    Button reg;
    private LoginPresenter presenter;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Intent intent = new Intent(LoginActivity.this, PersonInfoActivity.class);
                    startActivity(intent);
                    finish();
                    break;

                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //调用p层
        presenter = new LoginPresenter(this);

        //调用工具类判断保存的布尔值
        boolean b = SharedUtils.getBooleanData(LoginActivity.this, "flag", false);

        if (b) {    //已经进入过，现在是第二次
            handler.sendEmptyMessageDelayed(0, 0);
        } else {        //现在是第一次
            SharedUtils.savaBooleanData(LoginActivity.this, "flag", true);
        }

    }

    @Override
    public void success(LoginBean loginBean) {
        Toast.makeText(this, "登录结果：  " + loginBean.getMsg(), Toast.LENGTH_SHORT).show();

        if(loginBean.getMsg().equals("登录成功")){
            try {
                Thread.sleep(1000);
                Intent intent = new Intent(LoginActivity.this, PersonInfoActivity.class);
                startActivity(intent);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void failed(int code) {
        Toast.makeText(this, "登录失败！请检查登录信息" + code, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn, R.id.reg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                if (!TextUtils.isEmpty(tel.getText().toString()) && !TextUtils.isEmpty(pwd.getText().toString())) {
                    //如果都不为空,请求接口
                    presenter.getData(tel.getText().toString(), pwd.getText().toString());
                } else {
                    Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.reg:      //注册页
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                break;
        }
    }
}
