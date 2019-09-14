package net.kathir.myapplication.mvpwithDI.di.module;

import net.kathir.myapplication.mvpwithDI.di.module.MainActivityContextModule;
import net.kathir.myapplication.mvpwithDI.MVPMainActivity;
import net.kathir.myapplication.mvpwithDI.RecyclerViewAdapter;
import net.kathir.myapplication.mvpwithDI.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getCoinList(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MVPMainActivity mainActivity) {
        return mainActivity;
    }
}
