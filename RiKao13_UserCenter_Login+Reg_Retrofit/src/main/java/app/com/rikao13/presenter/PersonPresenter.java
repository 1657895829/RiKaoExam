package app.com.rikao13.presenter;

import app.com.rikao13.bean.PersonInfoBean;
import app.com.rikao13.model.ModelCallBack;
import app.com.rikao13.model.PersonModel;
import app.com.rikao13.view.MyView;

/**
 * 个人p层
 */

public class PersonPresenter {

    PersonModel personModel = new PersonModel();
    MyView.PersonView personView;
    public PersonPresenter(MyView.PersonView personView) {
        this.personView = personView;
    }

    public void getData(int uid) {
        personModel.getPersonData(uid, new ModelCallBack.PersonCallBack() {
            @Override
            public void success(PersonInfoBean personInfoBean) {
                personView.sucess(personInfoBean);
                System.out.println("个人p数据："+personInfoBean.toString());
            }

            @Override
            public void failed(Throwable code) {
                System.out.println("个人p错误："+code);
            }
        });
    }
}
