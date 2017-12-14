package app.example.com.settingsdemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import app.example.com.settingsdemo.bean.VersionBean;
import app.example.com.settingsdemo.presenter.MyPresenter;
import app.example.com.settingsdemo.util.DownloadUtil;
import app.example.com.settingsdemo.view.MyView;

public class MainActivity extends Activity implements MyView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        //实例化p层
        MyPresenter presenter = new MyPresenter(this);
        presenter.get(0);

        FrameLayout container = findViewById(R.id.container);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"版本已更新",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSuccess(VersionBean bean) {
        if (bean.getCode().equals("0")){
            Toast.makeText(MainActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
        }
        if (bean.getMsg().equals("获取版本信息成功")){
            String apkUrl = bean.getData().getApkUrl();
            DownloadUtil.get(apkUrl, new DownloadUtil.OnDownloadListener() {
                @Override
                public void onDownloadSuccess() {
                    Toast.makeText(MainActivity.this, "下载完成",Toast.LENGTH_SHORT).show();
                }
//                @Override
//                public void onDownloading(int progress) {
//                    progressBar.setProgress(progress);
//                }
                @Override
                public void onDownloadFailed() {
                    Toast.makeText(MainActivity.this, "下载失败",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onFailure(Exception e) {

    }

    /**
     * A placeholder fragment containing a simple MyView.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}