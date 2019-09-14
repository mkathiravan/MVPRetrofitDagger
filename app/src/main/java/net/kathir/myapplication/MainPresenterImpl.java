package net.kathir.myapplication;

import java.util.ArrayList;
import java.util.List;

public class MainPresenterImpl implements MainContract.Presenter,MainContract.GetNoticeIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetNoticeIntractor getNoticeIntractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetNoticeIntractor getNoticeIntractor) {
        this.mainView = mainView;
        this.getNoticeIntractor = getNoticeIntractor;
    }

    @Override
    public void onDestroy() {

        mainView = null;
    }

    @Override
    public void onRefreshButtonClick() {

        if(mainView!= null)
        {
            mainView.showProgress();
        }

        getNoticeIntractor.getNoticeArrayList(this);
    }

    @Override
    public void requestDataFromServer() {

        getNoticeIntractor.getNoticeArrayList(this);
    }


    @Override
    public void onFinished(List<Employee> employeeArrayList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(employeeArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }

    }
}
