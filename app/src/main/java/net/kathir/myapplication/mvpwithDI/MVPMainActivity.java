package net.kathir.myapplication.mvpwithDI;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.kathir.myapplication.R;
import net.kathir.myapplication.mvpwithDI.di.component.ApplicationComponent;
import net.kathir.myapplication.mvpwithDI.di.component.DaggerMainActivityComponent;
import net.kathir.myapplication.mvpwithDI.di.component.MainActivityComponent;
import net.kathir.myapplication.mvpwithDI.di.module.MainActivityContextModule;
import net.kathir.myapplication.mvpwithDI.di.module.MainActivityMvpModule;
import net.kathir.myapplication.mvpwithDI.di.qualifier.ActivityContext;
import net.kathir.myapplication.mvpwithDI.di.qualifier.ApplicationContext;
import net.kathir.myapplication.mvpwithDI.mvp.MainActivityContract;
import net.kathir.myapplication.mvpwithDI.mvp.PresenterImpl;
import net.kathir.myapplication.mvpwithDI.pojo.CryptoData;

import java.util.List;

import javax.inject.Inject;

public class MVPMainActivity extends AppCompatActivity implements MainActivityContract.View, RecyclerViewAdapter.ClickListener {


    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    MainActivityComponent mainActivityComponent;
    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;
    @Inject
    @ApplicationContext
    public Context mContext;
    @Inject
    @ActivityContext
    public Context activityContext;
    @Inject
    PresenterImpl presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ApplicationComponent applicationComponent = MyApplication.get(MVPMainActivity.this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .mainActivityMvpModule(new MainActivityMvpModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
        recyclerView.setAdapter(recyclerViewAdapter);
        progressBar = findViewById(R.id.progressBar);

        presenter.loadData();
    }

    @Override
    public void launchIntent(String name) {
        Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
        // startActivity(new Intent(activityContext, DetailActivity.class).putExtra("name", name));
    }

    @Override
    public void showData(List<CryptoData> data) {
        recyclerViewAdapter.setData(data);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
