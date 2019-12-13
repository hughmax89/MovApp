package com.hgs.movapp.di.components;

import com.hgs.domain.repository.IMovieRepository;
import com.hgs.movapp.activity.MovieActivity;
import com.hgs.movapp.di.PerActivity;
import com.hgs.movapp.di.modules.ActivityModule;
import com.hgs.movapp.di.modules.MovieModule;
import com.hgs.movapp.fragment.DetailsMovieFragment;
import com.hgs.movapp.fragment.MoviePopularFragment;
import com.hgs.movapp.fragment.MovieTopRatedFragment;
import com.hgs.movapp.fragment.MovieUpcomingFragment;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, MovieModule.class})
public interface MovieComponent extends ActivityComponent{

    void inject(MovieActivity movieActivity);
    void inject(MoviePopularFragment moviePopularFragment);
    void inject(MovieTopRatedFragment movieTopRatedFragment);
    void inject(MovieUpcomingFragment movieUpcomingFragment);
    void inject(DetailsMovieFragment detailsMovieFragment);

    IMovieRepository movieRepository();
}
