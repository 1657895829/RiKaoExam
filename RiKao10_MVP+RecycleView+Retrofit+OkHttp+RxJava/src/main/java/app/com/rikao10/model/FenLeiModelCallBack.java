package app.com.rikao10.model;

import java.util.List;
import app.com.rikao10.bean.ChildBean;
import app.com.rikao10.bean.LeftBean;
import app.com.rikao10.bean.RightBean;

/**
 * 分类页面model层接口类
 */
public interface FenLeiModelCallBack {
    public void LeftCallBack(List<LeftBean.DataBean> leftCallBack);//z左侧成功
    public void RightCallBack(List<RightBean.DataBean> rightCallBack); //右侧成功

    //子类数据成功
    public void ChildCallBack(List<ChildBean.DataBean> childCallBack);
}
