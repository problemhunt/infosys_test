package com.problemhunt.shailendra.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.problemhunt.shailendra.R;
import com.problemhunt.shailendra.Utils;
import com.problemhunt.shailendra.models.AboutModel;

import java.util.ArrayList;



public class AboutCountryAdapter extends RecyclerView.Adapter<AboutCountryAdapter.ViewHolder> {

    private ArrayList<AboutModel> facts;
    private Context context;

    public AboutCountryAdapter(ArrayList<AboutModel> facts, Context context) {
        this.facts = facts;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fact, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final AboutModel fact = facts.get(position);
        holder.tvTitle.setText(fact.getTitle());
        holder.tvTitle.setVisibility(Utils.notEmptyOrNull(fact.getTitle()) ? View.VISIBLE : View.GONE);
        holder.tvDescription.setText(fact.getDescription());
        holder.tvDescription.setVisibility(Utils.notEmptyOrNull(fact.getDescription()) ? View.VISIBLE : View.GONE);

        holder.ivFactPic.setVisibility(View.VISIBLE);

        final RequestCreator picasso = Picasso.with(context)
                .load(fact.getImageUrl()).networkPolicy(NetworkPolicy.OFFLINE);
        picasso.into(holder.ivFactPic, new Callback() {
            @Override
            public void onSuccess() {
                //Working properly.
            }

            @Override
            public void onError() {
                Picasso.with(context).load(fact.getImageUrl()).into(holder.ivFactPic);
            }
        });

    }

    @Override
    public int getItemCount() {
        return facts != null ? facts.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDescription;
        ImageView ivFactPic;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_fact_title);
            tvDescription = itemView.findViewById(R.id.tv_fact_description);
            ivFactPic = itemView.findViewById(R.id.iv_fact_image);
        }
    }
}
