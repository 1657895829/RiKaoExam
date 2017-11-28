package com.dhw.rikao.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.dhw.rikao.R;
import com.dhw.rikao.bean.WeiXinBean;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

/**
 * 自定义适配器类
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<WeiXinBean.NewslistBean> list;

    public MyAdapter(Context context, List<WeiXinBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return  list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //重写适配器的4个方法，并在显示视图的方法中做优化
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            //加载布局为一个视图
            view = View.inflate(context, R.layout.adapter, null);

            //查找控件
            holder.draweeView = (SimpleDraweeView) view.findViewById(R.id.draweeView);
            holder.title = (TextView) view.findViewById(R.id.title);
            holder.time = (TextView) view.findViewById(R.id.time);

            //绑定数据
            view.setTag(holder);
        } else {
            //解绑数据
            holder = (ViewHolder) view.getTag();
        }
        //在view视图中设置控件属性
        Uri uri = Uri.parse(list.get(i).getPicUrl());
        holder.draweeView.setImageURI(uri);
        holder.title.setText(list.get(i).getTitle());
        holder.time.setText(list.get(i).getCtime());

        return view;
    }

    static class ViewHolder {
        SimpleDraweeView draweeView;
        TextView title;
        TextView time;
    }
}
