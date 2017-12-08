package app.com.rikao10.presenter;
import java.util.List;
import app.com.rikao10.bean.ChildBean;
import app.com.rikao10.bean.LeftBean;
import app.com.rikao10.bean.RightBean;
import app.com.rikao10.model.FenLeiModel;
import app.com.rikao10.model.FenLeiModelCallBack;
import app.com.rikao10.view.FenLeiView;

/**
 * 分类页面presenter层
 */

public class FenLeiPresenter {
    private FenLeiView fenLeiView;
    private FenLeiModel fenLeiModel;

    public FenLeiPresenter(FenLeiView fenLeiView) {
        this.fenLeiView = fenLeiView;
        this.fenLeiModel = new FenLeiModel();
    }

    //获取左边数据的方法
    public void getLeftData(){
        fenLeiModel.getLeftModel(new FenLeiModelCallBack() {
            @Override
            public void LeftCallBack(List<LeftBean.DataBean> leftCallBack) {
                if (fenLeiView != null){
                    fenLeiView.ShowLeftData(leftCallBack);
                    System.out.println("Presenter层左边数据成功返回"+leftCallBack.toString());
                }
            }

            @Override
            public void RightCallBack(List<RightBean.DataBean> rightCallBack) {
                if (fenLeiView != null){
                    fenLeiView.ShowRightData(rightCallBack);
                    System.out.println("Presenter层右边数据成功返回"+rightCallBack.toString());
                }
            }

            @Override
            public void ChildCallBack(List<ChildBean.DataBean> childCallBack) {
                if (fenLeiView != null){
                    fenLeiView.ShowChildData(childCallBack);
                }
            }
        });
    }

    //获取右边数据的方法
    public void getRightData(int count){
        fenLeiModel.getRightModel(count, new FenLeiModelCallBack() {
            @Override
            public void LeftCallBack(List<LeftBean.DataBean> leftCallBack) {
                if (fenLeiView != null){
                    fenLeiView.ShowLeftData(leftCallBack);
                    System.out.println("Presenter层左边数据成功返回"+leftCallBack.toString());
                }
            }

            @Override
            public void RightCallBack(List<RightBean.DataBean> rightCallBack) {
                if (fenLeiView != null){
                    fenLeiView.ShowRightData(rightCallBack);
                    System.out.println("Presenter层右边数据成功返回"+rightCallBack.toString());
                }
            }

            @Override
            public void ChildCallBack(List<ChildBean.DataBean> childCallBack) {
                if (fenLeiView != null){
                    fenLeiView.ShowChildData(childCallBack);
                }
            }
        });
    }

    //取消绑定，防止内存泄漏
    public void detach(){
        fenLeiView = null;
    }
}
