package com.example.pandavpn.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pandavpn.Model.SplitModel;
import com.example.pandavpn.R;

import java.util.ArrayList;
import java.util.Locale;

public class SplitAdapter extends RecyclerView.Adapter<SplitAdapter.ViewHolder> {
    ArrayList<SplitModel> sectionList;
    Context mcontext;
    SplitAdapter.OnItemClickListener itemClickListener;
    private ArrayList<SplitModel> arraylist = new ArrayList<>();

    public SplitAdapter(Activity ctx, ArrayList<SplitModel> sectionList, SplitAdapter.OnItemClickListener clickListener) {
        this.sectionList = sectionList;
        this.mcontext = ctx;
        this.itemClickListener = clickListener;
        this.arraylist.addAll(sectionList);
    }

    @NonNull
    @Override
    public SplitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.split_row, parent, false);
        return new SplitAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SplitAdapter.ViewHolder holder, int position) {

        SplitModel section = sectionList.get(position);
        String sectionName = section.getAppName();

        holder.app_name.setText(sectionName);


        holder.main.setOnClickListener(v -> {
            itemClickListener.onItemClicked(section, position, section.isStatus());
        });


    }



    @Override
    public int getItemCount() {
        return sectionList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView app_name;
        LinearLayout main;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            app_name = itemView.findViewById(R.id.app_name);
//            selection = itemView.findViewById(R.id.selection);
            main = itemView.findViewById(R.id.layout);
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(SplitModel server, int postion, boolean favorite);
    }
}
