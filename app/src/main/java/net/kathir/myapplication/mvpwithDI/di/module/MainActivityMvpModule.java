package net.kathir.myapplication.mvpwithDI.di.module;



import net.kathir.myapplication.mvpwithDI.mvp.MainActivityContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityMvpModule {

    private final MainActivityContract.View mView;


    public MainActivityMvpModule(MainActivityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @net.kathir.myapplication.mvpwithDI.di.scopes.ActivityScope
    MainActivityContract.View provideView() {
        return mView;
    }




}
