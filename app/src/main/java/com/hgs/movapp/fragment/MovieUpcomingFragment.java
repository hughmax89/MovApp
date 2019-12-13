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
import com.hgs.movapp.adapter.MovieListAdapter;
import com.hgs.movapp.base.BaseFragment;
import com.hgs.movapp.base.BaseView;
import com.hgs.movapp.contracts.MovieContract;
import com.hgs.movapp.di.HasComponent;
import com.hgs.movapp.di.components.MovieComponent;
import com.hgs.movapp.presenter.MoviePresenter;
import com.hgs.movapp.utils.RecyclerTouchListener;

import java.util.List;

import javax.inject.Inject;

public class MovieUpcomingFragment  extends BaseFragment implements MovieContract.View, HasComponent<MovieComponent> {
    @Inject
    MoviePresenter mPresenter;

    private MovieComponent movieComponent;
    private MovieListAdapter adapter;
    RecyclerView recyclerView;
    private ProgressDialog mProgressDialog;

    public MovieUpcomingFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(MovieComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_movie, container, false);

        bindingForElements(view);
        defineUIEvents();

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.mPresenter.setView(this);

        mPresenter.GetMoviesUpcoming();
    }

    private void defineUIEvents() {

    }

    private void bindingForElements(View view) {
        recyclerView = view.findViewById(R.id.rvMoviesList);
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
    public MovieComponent getComponent() {
        return movieComponent;
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
    public void setReultMoviesPopular(List<Movie> movieList) {

    }

    @Override
    public void setReultMoviesTopRated(List<Movie> movieList) {

    }

    @Override
    public void setReultMoviesUpcoming(List<Movie> movieList) {

    }

    public void setView(BaseView view) {

    }


}
