package com.test.photoflickr.view.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.test.photoflickr.R;
import com.test.photoflickr.model.entity.Photo_;
import com.test.photoflickr.view.adapter.FlickrPhotoAdapter;
import com.test.photoflickr.viewmodel.SearchViewModel;

import java.util.ArrayList;
import java.util.List;


public class SearchPhotoActivityFragment extends Fragment implements SearchViewModel.SearchPhotoListener{

    private FlickrPhotoAdapter adapter;
    private SearchViewModel mSearchViewModel;
    private int currentPage = 1;
    private String lastQuery;
    private UltimateRecyclerView myRecyclerView;

    public SearchPhotoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_photo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSearchViewModel = new SearchViewModel(getActivity(), this);

        myRecyclerView = (UltimateRecyclerView) view.findViewById(R.id.my_recycler_view);
        myRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new FlickrPhotoAdapter(new ArrayList<Photo_>());
        adapter.setOnPhotoItemClickListener(new FlickrPhotoAdapter.PhotoItemClickListener() {
            @Override
            public void onItemClicked(Photo_ photo_, int position) {

            }
        });

        myRecyclerView.setAdapter(adapter);

        adapter.setCustomLoadMoreView(LayoutInflater.from(getActivity())
                .inflate(R.layout.progressbar_layout, null));

        myRecyclerView.enableLoadmore();

        myRecyclerView.setOnLoadMoreListener(new UltimateRecyclerView.OnLoadMoreListener(){

             @Override
             public void loadMore(int itemsCount, int maxLastVisiblePosition) {

                 currentPage++;
                 mSearchViewModel.searchPhotoByWord(lastQuery, currentPage);
             }
         });
    }

    public void searchByWord(String word){

        adapter.clearData();
        myRecyclerView.invalidate();

        lastQuery = word;
        mSearchViewModel.searchPhotoByWord(word, currentPage);
    }

    public boolean adapterIsEmpty(){

        int count = adapter.getAdapterItemCount();

        if(count == 0){
            return true;
        }

        return false;
    }

    @Override
    public void onSearchResult(List<Photo_> photos) {

        if(adapterIsEmpty()){
            adapter.addMoreList(photos);
        } else {

            for(Photo_ p : photos){
                adapter.addMore(p, adapter.getAdapterItemCount() - 1);
            }
        }
    }

    @Override
    public void onSearchError() {}
}