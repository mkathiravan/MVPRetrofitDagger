package net.kathir.myapplication.mvpwithDI.di.component;

import android.content.Context;

import net.kathir.myapplication.mvpwithDI.retrofit.APIInterface;
import net.kathir.myapplication.mvpwithDI.MyApplication;
import net.kathir.myapplication.mvpwithDI.di.module.ContextModule;
import net.kathir.myapplication.mvpwithDI.di.module.RetrofitModule;


import dagger.Component;

@net.kathir.myapplication.mvpwithDI.di.scopes.ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    APIInterface getApiInterface();

    @net.kathir.myapplication.mvpwithDI.di.qualifier.ApplicationContext
    Context getContext();

    void injectApplication(MyApplication myApplication);
}
