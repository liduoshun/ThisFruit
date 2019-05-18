package com.example.thisfruit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FruitFragment extends Fragment {

    ImageView head;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;

    FruitMatch fruitMatch = new FruitMatch(R.raw.apple,R.raw.match);

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fruit_fragment,container,false);
        head = view.findViewById(R.id.handPaint);
        imageView1 = view.findViewById(R.id.matchPaint1);
        imageView2 = view.findViewById(R.id.matchPaint2);
        imageView3 = view.findViewById(R.id.matchPaint3);
        imageView4 = view.findViewById(R.id.matchPaint4);

        head.setImageResource(fruitMatch.getHandPaint());
        imageView1.setImageResource(R.raw.match);
        imageView2.setImageResource(R.raw.match);
        imageView3.setImageResource(fruitMatch.getRealPaint());
        imageView4.setImageResource(R.raw.match);

        return view;
    }
}
