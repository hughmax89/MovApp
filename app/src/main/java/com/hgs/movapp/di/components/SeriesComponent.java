package com.hgs.movapp.di.components;


import com.hgs.domain.repository.ISeriesRepository;
import com.hgs.movapp.activity.SeriesActivity;
import com.hgs.movapp.di.PerActivity;
import com.hgs.movapp.di.modules.ActivityModule;
import com.hgs.movapp.di.modules.SeriesModule;
import com.hgs.movapp.fragment.DetailsMovieFragment;
import com.hgs.movapp.fragment.DetailsSeriesFragment;
import com.hgs.movapp.fragment.SeriesPopularFragment;
import com.hgs.movapp.fragment.SeriesTopRatedFragment;
import com.hgs.movapp.fragment.SeriesUpcomingFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, SeriesModule.class})
public interface SeriesComponent extends ActivityComponent{

    void inject(SeriesActivity seriesActivity);
    void inject(SeriesPopularFragment seriesPopularFragment);
    void inject(SeriesTopRatedFragment seriesTopRatedFragment);
    void inject(SeriesUpcomingFragment seriesUpcomingFragment);
    void inject(DetailsSeriesFragment detailsSeriesFragment);

    ISeriesRepository seriesRepository();
}
