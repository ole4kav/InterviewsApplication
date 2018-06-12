package com.example.olga.interviewsapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.olga.interviewsapplication.R;

import java.util.List;

public class SentencesAdapter extends RecyclerView.Adapter<SentencesAdapter.ViewHolder> {

        private List<String> mData;
        private LayoutInflater mInflater;
        private ItemClickListener mClickListener;
        Context mContext;

        // data is passed into the constructor
        public SentencesAdapter(Context context, List<String> data) {
            mInflater = LayoutInflater.from(context);
            mData = data;
            mContext = context;
        }

        // inflates the row layout from xml when needed
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.sentence_row, parent, false);
            return new ViewHolder(view);
        }

        // binds the data to the TextView in each row
        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String sentences = mData.get(position);
            holder.rowTextView.setText((position+1) + mContext.getString(R.string.dot) + sentences);
        }

        // total number of rows
        @Override
        public int getItemCount() {
            return mData.size();
        }


        // stores and recycles views as they are scrolled off screen
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView rowTextView;

            ViewHolder(View itemView) {
                super(itemView);
                rowTextView = itemView.findViewById(R.id.tvRowSentence);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if (mClickListener != null) {
                    mClickListener.onItemClick(view, getAdapterPosition());
                }
            }
        }

        // convenience method for getting data at click position
        public String getItem(int id) {
            return mData.get(id);
        }

        // allows clicks events to be caught
        public void setClickListener(ItemClickListener itemClickListener) {
            this.mClickListener = itemClickListener;
        }

        // parent activity will implement this method to respond to click events
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
}
