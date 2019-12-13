package com.hgs.movapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hgs.data.entity.MovieEntity;
import com.hgs.movapp.R;
import com.hgs.movapp.base.BaseFragment;
import com.hgs.movapp.di.HasComponent;
import com.hgs.movapp.di.components.MovieComponent;
import com.squareup.picasso.Picasso;

import java.io.File;

public class DetailsMovieFragment extends BaseFragment  implements HasComponent<MovieComponent> {

    private MovieComponent movieComponent;
    private ImageView poster;
    private TextView title, genero, description, popularity;
    private MovieEntity movieEntity;

    public DetailsMovieFragment()
    {setRetainInstance(true);}

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.getComponent(MovieComponent.class).inject(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater,container,savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_details, container, false);

        Bundle bundle = this.getArguments();
        if (getArguments().containsKey("details"))
        {
            movieEntity = bundle.getParcelable("details");

            ((TextView) view.findViewById(R.id.title)).setText(movieEntity.title);
            ((TextView) view.findViewById(R.id.description)).setText(movieEntity.overview);
            ((TextView) view.findViewById(R.id.Calificación)).setText(movieEntity.popularity);
            if (movieEntity.poster_path != null && !movieEntity.poster_path.isEmpty()) {
                if (movieEntity.poster_path.contains("http")) {
                    Picasso.with(getContext())
                            .load(movieEntity.poster_path)
                            .fit()
                            .placeholder(R.drawable.retro_tv_64px)
                            .centerCrop()
                            .into((ImageView) view.findViewById(R.id.image));
                }
                else {
                    Picasso.with(getContext())
                            .load(new File(movieEntity.poster_path))
                            .fit()
                            .placeholder(R.drawable.retro_tv_64px)
                            .centerCrop()
                            .into((ImageView) view.findViewById(R.id.image));
                }
            }
            else {
                Picasso.with(getContext())
                        .load(R.drawable.retro_tv_64px)
                        .placeholder(R.drawable.retro_tv_64px)
                        .into((ImageView) view.findViewById(R.id.image));
            }
        }

        return view;
    }


    @Override
    public MovieComponent getComponent() {
        return movieComponent;
    }
}
