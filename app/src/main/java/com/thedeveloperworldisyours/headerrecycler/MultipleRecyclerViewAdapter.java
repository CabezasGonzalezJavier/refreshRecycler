package com.thedeveloperworldisyours.headerrecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 4/7/17.
 */

public class MultipleRecyclerViewAdapter extends RecyclerView
        .Adapter<RecyclerView.ViewHolder> {

    private List<MultipleData> mList;
    private static MultipleClickListener sClickListener;

    MultipleRecyclerViewAdapter(List<MultipleData> mList) {
        this.mList = mList;
    }

    static class SectionHolder extends RecyclerView.ViewHolder {
        TextView mTextViewSection;

        SectionHolder(View itemView) {
            super(itemView);

            mTextViewSection = (TextView) itemView.findViewById(R.id.section_list_item_text);
        }
    }

    static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        TextView mTextView;
        RadioButton mRadioButton;

        DataObjectHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.multiple_list_item_text);
            mRadioButton = (RadioButton) itemView.findViewById(R.id.multiple_list_item_check_button);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    void changedData(List<MultipleData> list) {
        mList.clear();
        notifyDataSetChanged();
        mList = list;
        notifyDataSetChanged();
    }

    void setOnItemClickListener(MultipleClickListener myClickListener) {
        this.sClickListener = myClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.multiple_list_item, parent, false);
        View viewSection = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section_list_item, parent, false);

        switch (viewType) {
            case 0:
                return new DataObjectHolder(view);
            case 2:
                return new SectionHolder(viewSection);
            default:
                return new SectionHolder(viewSection);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                DataObjectHolder dataObjectHolder = (DataObjectHolder) holder;
                dataObjectHolder.mTextView.setText(mList.get(position).getTitle());
                dataObjectHolder.mRadioButton.setChecked(mList.get(position).isBoolean());
                break;

            case 2:
                SectionHolder sectionHolder = (SectionHolder) holder;
                sectionHolder.mTextViewSection.setText(mList.get(position).getTitle());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    interface MultipleClickListener {
        void onItemClick(int position, View v);
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position).ismSection()) {
            return 2;
        } else {
            return 0;
        }
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous

    }

}
