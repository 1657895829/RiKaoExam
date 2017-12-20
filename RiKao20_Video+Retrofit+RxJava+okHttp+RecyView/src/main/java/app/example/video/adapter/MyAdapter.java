package app.example.video.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import app.example.video.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * RecyclerView展示数据
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载布局
        View view = View.inflate(context, R.layout.adapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //设置商品信息，使用Fresco加载图片
        holder.image.setImageURI("https://m.360buyimg.com//n0//jfs//t6700//155//2098998076//156185//6cf95035//595dd5a5Nc3a7dab5.jpg!q70.jpg");
        holder.customXqTitle.setText("小米(MI)Air 13.3英寸全金属轻薄笔记本(i5-7200U 8G 256G PCle SSD MX150 2G独显 FHD 指纹识别 Win10）银");
        holder.customXqBarginPrice.setText("¥11800.0");
        holder.shopTitle.setText("我是商家1");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        SimpleDraweeView image;
        @BindView(R.id.custom_xq_title)
        TextView customXqTitle;
        @BindView(R.id.custom_xq_bargin_price)
        TextView customXqBarginPrice;
        @BindView(R.id.shop_title)
        TextView shopTitle;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
