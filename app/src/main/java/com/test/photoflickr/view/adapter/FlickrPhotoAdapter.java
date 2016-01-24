package com.test.photoflickr.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;
import com.test.photoflickr.R;
import com.test.photoflickr.databinding.PhotoItemBinding;
import com.test.photoflickr.model.entity.Photo_;
import com.test.photoflickr.viewmodel.ItemPhotoViewModel;

import java.util.ArrayList;
import java.util.List;


public class FlickrPhotoAdapter extends UltimateViewAdapter<FlickrPhotoAdapter.BindingHolder> {

    private List<Photo_> photos = new ArrayList<>();
    private PhotoItemClickListener photoItemClickListener;

    public FlickrPhotoAdapter(List<Photo_> photos){
        this.photos = photos;
    }

    public void addMoreList(List<Photo_> photos){
        this.photos = photos;
        notifyDataSetChanged();
    }

    public void clearData() {
        this.photos.clear();
        notifyDataSetChanged();
    }

    public void setOnPhotoItemClickListener(PhotoItemClickListener photoItemClickListener){
        this.photoItemClickListener = photoItemClickListener;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent) {

        PhotoItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.photo_item,
                parent,
                false);

        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(final BindingHolder holder, final int position) {

        //To avoid ArrayIndexOutOfBoundException
        if(position < this.photos.size() ){

            final Photo_ photo = this.photos.get(position);
            holder.bindPhoto(photo);
//            holder.getBinding().cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    FlickrPhotoAdapter.this.photoItemClickListener.onItemClicked(photo, position);
//                }
//            });
        }
    }

    @Override
    public int getAdapterItemCount() {
        return  photos != null ? photos.size() : 0;
    }

    @Override
    public long generateHeaderId(int position) {
        return -1;
    }

    public void addMore(Photo_ photo, int position){
        insert(this.photos, photo, position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public BindingHolder getViewHolder(View view) {
        return  new BindingHolder(view);
    }

    public static class BindingHolder extends UltimateRecyclerviewViewHolder {

        private PhotoItemBinding binding;

        public BindingHolder(View view) {
            super(view);
        }

        public BindingHolder(PhotoItemBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }

        public PhotoItemBinding getBinding() {
            return binding;
        }

        void bindPhoto(Photo_ photo) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new ItemPhotoViewModel(itemView.getContext(), photo));
            } else {
                binding.getViewModel().setPhoto(photo);
            }
        }
    }

    public interface PhotoItemClickListener{
        void onItemClicked(Photo_ photo_, int position);
    }
}