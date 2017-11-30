package com.dhw.event_knife_recyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhw.event_knife_recyclerview.EventBusSticky;
import com.dhw.event_knife_recyclerview.R;
import com.dhw.event_knife_recyclerview.SecondActivity;
import com.dhw.event_knife_recyclerview.bean.WeiXinBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 自定义适配器类
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<WeiXinBean.NewslistBean> list;

    public MyAdapter(Context context, List<WeiXinBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    //创建ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载布局为一个视图
        View view = LayoutInflater.from(context).inflate( R.layout.adapter, null);
        return new MyViewHolder(view);
    }

    // 绑定view 显示数据
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //在view视图中设置控件属性
        Uri uri = Uri.parse(list.get(position).getPicUrl());
        holder.draweeView.setImageURI(uri);
        holder.title.setText(list.get(position).getTitle());
        holder.time.setText(list.get(position).getCtime());

        //点击条目跳到第二页面
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //携带数据，实现点击跳转，发送黏性事件
                EventBus.getDefault().postSticky(new EventBusSticky(list.get(position).getTitle()));
                context.startActivity(new Intent(context, SecondActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //使用ButterKnife初始化控件
    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.draweeView)
        SimpleDraweeView draweeView;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.time)
        TextView time;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
