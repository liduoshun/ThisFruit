package com.example.thisfruit;

import android.media.AudioFocusRequest;

import java.util.HashMap;
import java.util.Map;

public class FruitMatch {
    private static Map<Integer, Integer> ans = new HashMap<>();

    FruitMatch(){
        ans.put(R.drawable.a01, R.drawable.a02);
        ans.put(R.drawable.a11, R.drawable.a12);
        ans.put(R.drawable.a21, R.drawable.a22);
        ans.put(R.drawable.a31, R.drawable.a32);
        ans.put(R.drawable.a41, R.drawable.a42);
    }

    public static boolean isMatch(int head, int img) {
        return ans.get(head) == img;
    }


}
