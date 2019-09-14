package net.kathir.myapplication;

import java.util.ArrayList;
import java.util.List;

public interface MainContract {

    /** Call when user interact with the view and other when view onDestory() **/

    interface Presenter
    {
        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();
    }

    /** showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/

    interface MainView
    {
        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<Employee> employeeArrayList);

        void onResponseFailure(Throwable throwable);


    }


    /**  Intractors are classes built for fetching data from your database, web services, or any other data source   **/

    interface GetNoticeIntractor
    {
        interface OnFinishedListener {
            void onFinished(List<Employee> employeeArrayList);

            void onFailure(Throwable t);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener);
    }



}
