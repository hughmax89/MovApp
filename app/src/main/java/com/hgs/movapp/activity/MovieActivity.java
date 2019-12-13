package com.hgs.movapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.hgs.domain.core.Movie;
import com.hgs.movapp.R;
import com.hgs.movapp.base.BaseActivity;
import com.hgs.movapp.contracts.MovieContract;
import com.hgs.movapp.di.HasComponent;
import com.hgs.movapp.di.components.DaggerMovieComponent;
import com.hgs.movapp.di.components.MovieComponent;
import com.hgs.movapp.fragment.MoviePopularFragment;
import com.hgs.movapp.fragment.MovieTopRatedFragment;
import com.hgs.movapp.fragment.MovieUpcomingFragment;
import com.hgs.movapp.presenter.MoviePresenter;

import java.util.List;

import javax.inject.Inject;

public class MovieActivity extends BaseActivity implements MovieContract.View, HasComponent<MovieComponent> {

    @Inject
    MoviePresenter mPresenter;
    private MovieComponent movieComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        bindingForElements();
        defineUIevents();
        this.initializeInjector();

        Bundle bundle = this.getIntent().getExtras();

        if (bundle.containsKey("movie"))
        {
            int categoria = bundle.getParcelable("movie");
            if (categoria == 1)
            {
                addFragment(R.id.container_movie, new MoviePopularFragment());
            }
            if (categoria == 2)
            {
                addFragment(R.id.container_movie, new MovieTopRatedFragment());
            }
            if (categoria == 3)
            {
                addFragment(R.id.container_movie, new MovieUpcomingFragment());
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
        this.movieComponent = DaggerMovieComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    private void bindingForElements() {

    }


    private void defineUIevents() {


    }

    @Override
    public MovieComponent getComponent() {
        return movieComponent;
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
    public void setReultMoviesPopular(List<Movie> movieList) {

    }

    @Override
    public void setReultMoviesTopRated(List<Movie> movieList) {

    }

    @Override
    public void setReultMoviesUpcoming(List<Movie> movieList) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
