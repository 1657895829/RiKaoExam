package app.com.rikao10.view;


import java.util.List;
import app.com.rikao10.bean.ChildBean;
import app.com.rikao10.bean.LeftBean;
import app.com.rikao10.bean.RightBean;

/**
 * 分类页面的view接口
 */
public interface FenLeiView {
    public void ShowLeftData(List<LeftBean.DataBean> leftList);
    public void ShowRightData(List<RightBean.DataBean> rightList);
    //子类数据成功
    public void ShowChildData(List<ChildBean.DataBean> childList);
}
