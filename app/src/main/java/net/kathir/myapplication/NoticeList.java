package net.kathir.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NoticeList {

    private ArrayList<Employee> employeeList;

    public ArrayList<Employee> getNoticeArrayList() {
        return employeeList;
    }

    public void setNoticeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeList = employeeArrayList;
    }

}
