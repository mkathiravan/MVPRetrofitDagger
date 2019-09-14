package net.kathir.myapplication.mvpwithDI;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import net.kathir.myapplication.mvpwithDI.di.component.ApplicationComponent;
import net.kathir.myapplication.mvpwithDI.di.component.DaggerApplicationComponent;
import net.kathir.myapplication.mvpwithDI.di.module.ContextModule;

public class MyApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);

    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
