package net.kathir.myapplication.mvpwithDI.di.module;

import android.content.Context;


import net.kathir.myapplication.mvpwithDI.MVPMainActivity;
import net.kathir.myapplication.mvpwithDI.di.qualifier.ActivityContext;
import net.kathir.myapplication.mvpwithDI.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {

    private MVPMainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MVPMainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MVPMainActivity providesMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }

}
