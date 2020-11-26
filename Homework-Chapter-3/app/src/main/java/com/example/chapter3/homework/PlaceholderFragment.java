package com.example.chapter3.homework;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.airbnb.lottie.LottieAnimationView;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView animationView;
    private ListView listView;
    private String[] name = {"张三","李四","王五"};
    private String[] content ={"我是张三，你好","我是李四，你好","我是王五，你好"};
    private List<Map<String,Object>> lists;
    private SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View root = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView = root.findViewById(R.id.animation_view);
        listView = (ListView) root.findViewById(R.id.list_view);
        animationView.setAlpha(1f);
        listView.setAlpha(0f);

        lists = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("content", content[i]);
            map.put("name", name[i]);
            lists.add(map);
        }

        adapter = new SimpleAdapter(getActivity(), lists, R.layout.message_list,
                new String[]{"name", "content"}, new int[]{R.id.text1, R.id.text2});

        listView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator animation4 = ObjectAnimator.ofFloat(animationView,"alpha",1f,0f);
                ObjectAnimator animation5 = ObjectAnimator.ofFloat(listView,"alpha",0f,1f);
                animation4.setDuration(3000);
                animation5.setDuration(3000);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animation4,animation5);
                animatorSet.start();

            }
        }, 5000);
    }

    private List<Map<String,String>> getData(){

        List<Map<String,String>> data = new ArrayList<>();
        for(int i=0;i<5;++i){
            Map<String,String> map = new HashMap<String, String>();
            map.put("text","Message "+String.valueOf(i+1));
            data.add(map);
        }
        return data;
    }
}
