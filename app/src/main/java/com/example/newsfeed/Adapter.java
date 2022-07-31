package com.example.newsfeed;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ArticleModel> articles;

    public Adapter(Context context, ArrayList<ArticleModel> articles) {
        this.context = context;
        this.articles = articles;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView newsCard;
        TextView itemHeader;
        TextView itemDescription;
        ImageView itemImageView;
        TextView itemAuthor;
        TextView itemPublishedAt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            newsCard = itemView.findViewById(R.id.newsCard);
            itemHeader = itemView.findViewById(R.id.itemHeader);
            itemDescription = itemView.findViewById(R.id.itemDescription);
            itemImageView = itemView.findViewById(R.id.itemImageView);
            itemAuthor = itemView.findViewById(R.id.itemAuthor);
            itemPublishedAt = itemView.findViewById(R.id.itemPublishedAt);
        }
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.newsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url", articles.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.itemAuthor.setText(articles.get(position).getAuthor());
        holder.itemPublishedAt.setText(articles.get(position).getPublishedAt());
        holder.itemHeader.setText(articles.get(position).getTitle());
        holder.itemDescription.setText(articles.get(position).getTitle());

        Glide.with(context).load(articles.get(position).getUrlToImage()).into(holder.itemImageView);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
