package com.hgs.movapp.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.hgs.movapp.R;
import com.hgs.movapp.activity.MovieActivity;
import com.hgs.movapp.activity.SeriesActivity;
import com.hgs.movapp.base.BaseFragment;

import java.util.List;

public class MainFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private TextInputLayout tilSearch;
    private Button btnSearchByCode, btnSearchByTerm;
    private ProgressDialog mProgressDialog;
    private Button btn_movie_popular, btn_movie_topRated, btn_movie_upcoming,
            btn_series_popular, btn_series_topRated, btn_series_upcoming;

    public MainFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        bindingForElements(view);
        defineUIevents();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //this.mPresenter.setView(this);
        if (savedInstanceState == null) {
            //this.loadUserList();
        }
    }

    private void bindingForElements(View view) {
        mProgressDialog = new ProgressDialog(getActivity());
        btn_movie_popular =(Button)view.findViewById(R.id.btn_movie_pop);
        btn_movie_topRated =(Button)view.findViewById(R.id.btn_movie_top);
        btn_movie_upcoming =(Button)view.findViewById(R.id.btn_movie_upcoming);
        btn_series_popular = (Button) view.findViewById(R.id.btn_series_pop);
        btn_series_topRated = (Button) view.findViewById(R.id.btn_series_top);
        btn_series_upcoming = (Button) view.findViewById(R.id.btn_series_upcoming);
    }

    public void defineUIevents(){

        btn_movie_popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_regs=new Intent(getActivity(), MovieActivity.class);
                intent_regs.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent_regs.putExtra("movie", "1");
                startActivity(intent_regs);
            }
        });

        btn_movie_topRated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_regs=new Intent(getActivity(), MovieActivity.class);
                intent_regs.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent_regs.putExtra("movie", "2");
                startActivity(intent_regs);
            }
        });

        btn_movie_topRated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_regs=new Intent(getActivity(), MovieActivity.class);
                intent_regs.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent_regs.putExtra("movie", "3");
                startActivity(intent_regs);
            }
        });

        btn_series_popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SeriesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("series", "1");
                startActivity(intent);
            }
        });

        btn_series_topRated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SeriesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("series", "2");
                startActivity(intent);
            }
        });

        btn_series_upcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_regs=new Intent(getActivity(), SeriesActivity.class);
                intent_regs.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent_regs.putExtra("series", "3");
                startActivity(intent_regs);
            }
        });
    }

}
