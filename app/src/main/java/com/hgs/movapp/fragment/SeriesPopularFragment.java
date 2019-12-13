package com.hgs.movapp.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hgs.data.entity.MovieEntity;
import com.hgs.domain.core.Movie;
import com.hgs.movapp.R;
import com.hgs.movapp.adapter.SeriesListAdapter;
import com.hgs.movapp.base.BaseFragment;
import com.hgs.movapp.contracts.SeriesContract;
import com.hgs.movapp.di.HasComponent;
import com.hgs.movapp.di.components.SeriesComponent;
import com.hgs.movapp.presenter.SeriesPresenter;
import com.hgs.movapp.utils.RecyclerTouchListener;

import java.util.List;

import javax.inject.Inject;

public class SeriesPopularFragment extends BaseFragment implements SeriesContract.View, HasComponent<SeriesComponent> {

    @Inject
    SeriesPresenter mPresenter;

    private SeriesComponent seriesComponent;
    private SeriesListAdapter adapter;
    RecyclerView recyclerView;
    private ProgressDialog mProgressDialog;

    public SeriesPopularFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(SeriesComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_series, container, false);

        bindingForElements(view);
        defineUIEvents();

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mPresenter.setView(this);

    }

    private void defineUIEvents() {

    }

    private void bindingForElements(View view) {
        recyclerView = view.findViewById(R.id.rvSeriesList);
        mProgressDialog = new ProgressDialog(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration itemDecor = new DividerItemDecoration(this.getActivity(), LinearLayout.VERTICAL);
        recyclerView.addItemDecoration(itemDecor);
        recyclerView.addOnItemTouchListener(
                new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {

                        Movie itemMovie = adapter.getFilteredList().get(position);
                        MovieEntity itemMovieEntity = mapperToEntity(itemMovie, new MovieEntity());

                        DetailsMovieFragment fragment = new DetailsMovieFragment();

                        Bundle bundle = fillBundle(itemMovieEntity);

                        fragment.setArguments(bundle);

                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container_movie, fragment)
                                .commit();
                    }

                    @Override
                    public boolean onLongClick(View view, int position) {
                        return true;
                    }
                })
        );

    }

    private Bundle fillBundle(MovieEntity movieEntity) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("details", movieEntity);
        return bundle;
    }

    private MovieEntity mapperToEntity(Movie movie, MovieEntity entity) {

        entity.id = movie.getId();
        entity.poster_path = movie.getPoster_path();
        entity.title = movie.getTitle();
        entity.release_date = movie.getRelease_date();
        entity.overview = movie.getOverview();
        entity.popularity = movie.getPopularity();

        return entity;
    }

    @Override
    public SeriesComponent getComponent() {
        return seriesComponent;
    }

    @Override
    public void showLoadingIndicator() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoadingIndicator() {
        mProgressDialog.hide();
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
}
