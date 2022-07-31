package com.example.newsfeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class scienceFragment extends Fragment {

    ArrayList<ArticleModel> articles;
    Adapter adapter;
    String country = "in";
    private RecyclerView scienceRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.science_fragment, null);

        scienceRecyclerView = view.findViewById(R.id.scienceRecyclerView);
        articles = new ArrayList<>();
        scienceRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), articles);
        scienceRecyclerView.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {
        ApiUtilites.getApiInterface().getNames(country, "science", 100, ApiKey.ApiKey).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                articles.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getContext(), "Unable to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
