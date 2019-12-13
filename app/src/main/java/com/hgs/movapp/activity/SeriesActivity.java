package com.hgs.movapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.hgs.domain.core.Movie;
import com.hgs.movapp.R;
import com.hgs.movapp.base.BaseActivity;
import com.hgs.movapp.contracts.SeriesContract;
import com.hgs.movapp.di.HasComponent;
import com.hgs.movapp.di.components.DaggerSeriesComponent;
import com.hgs.movapp.di.components.SeriesComponent;
import com.hgs.movapp.fragment.SeriesPopularFragment;
import com.hgs.movapp.fragment.SeriesTopRatedFragment;
import com.hgs.movapp.fragment.SeriesUpcomingFragment;
import com.hgs.movapp.presenter.SeriesPresenter;

import java.util.List;

import javax.inject.Inject;

public class SeriesActivity extends BaseActivity implements SeriesContract.View, HasComponent<SeriesComponent> {

    @Inject
    SeriesPresenter mPresenter;
    private SeriesComponent seriesComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        bindingForElements();
        defineUIevents();
        this.initializeInjector();

        Bundle bundle = this.getIntent().getExtras();

        if (bundle.containsKey("series"))
        {
            int categoria = bundle.getParcelable("series");
            if (categoria == 1)
            {
                addFragment(R.id.container_series, new SeriesPopularFragment());
            }
            if (categoria == 2)
            {
                addFragment(R.id.container_series, new SeriesTopRatedFragment());
            }
            if (categoria == 3)
            {
                addFragment(R.id.container_series, new SeriesUpcomingFragment());
            }
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //onBackPressed();
                setGoToMainActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void setGoToMainActivity() {
        Intent intent_regs = new Intent(this, MainActivity.class);
        intent_regs.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent_regs);
        finish();
    }

    private void initializeInjector() {
        this.seriesComponent = DaggerSeriesComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    private void bindingForElements() {

    }


    private void defineUIevents() {


    }

    @Override
    public SeriesComponent getComponent() {
        return seriesComponent;
    }

    @Override
    public void showLoadingIndicator() {

    }

    @Override
    public void hideLoadingIndicator() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void setReultSeriesPopular(List<Movie> movieList) {

    }

    @Override
    public void setReultSeriesTopRated(List<Movie> movieList) {

    }

    @Override
    public void setReultSeriesUpcoming(List<Movie> movieList) {

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

