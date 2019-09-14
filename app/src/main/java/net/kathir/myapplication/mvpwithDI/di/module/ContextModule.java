package net.kathir.myapplication.mvpwithDI.di.module;

import android.content.Context;


import net.kathir.myapplication.mvpwithDI.di.qualifier.ApplicationContext;
import net.kathir.myapplication.mvpwithDI.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context)
    {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
