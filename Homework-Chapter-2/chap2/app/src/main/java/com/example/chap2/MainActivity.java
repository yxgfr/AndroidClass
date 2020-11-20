package com.example.chap2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SearchLayout searchLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerview = findViewById(R.id.list);
        final SearchAdapter searchAdapter = new SearchAdapter();
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(searchAdapter);

        final List<String> list = new ArrayList<>();
        for(int i =0;i<100;++i){
            list.add("这是第 " + i + " 行");
        }
        searchAdapter.notifyItems(list);

        searchLayout = findViewById(R.id.search);
        searchLayout.setOnInputChangedListener(new SearchLayout.OnInputChangedListener() {
            @Override
            public void onTextChanged(String text) {
                List<String> filters = new ArrayList<>();
                for(String item: list){
                    if (item.contains(text)){
                        filters.add(item);
                    }
                }
                searchAdapter.notifyItems(filters);
                Log.d("SearchActivity", "Changed: " + text);
            }
        });




    }
}
