package net.kathir.myapplication.mvpwithDI.di.component;

import android.content.Context;

import net.kathir.myapplication.mvpwithDI.di.component.ApplicationComponent;
import net.kathir.myapplication.mvpwithDI.di.module.MainActivityMvpModule;
import net.kathir.myapplication.mvpwithDI.MVPMainActivity;
import net.kathir.myapplication.mvpwithDI.di.module.AdapterModule;
import net.kathir.myapplication.mvpwithDI.di.qualifier.ActivityContext;
import net.kathir.myapplication.mvpwithDI.di.scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {AdapterModule.class, MainActivityMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();
    void injectMainActivity(MVPMainActivity mainActivity);
}
