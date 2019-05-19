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
        ans.put(R.drawable.a51, R.drawable.a52);
        ans.put(R.drawable.a61, R.drawable.a62);
        ans.put(R.drawable.a71, R.drawable.a72);
        ans.put(R.drawable.a81, R.drawable.a82);
        ans.put(R.drawable.a91, R.drawable.a92);
        ans.put(R.drawable.a101, R.drawable.a102);
        ans.put(R.drawable.a111, R.drawable.a112);
        ans.put(R.drawable.a121, R.drawable.a122);
        ans.put(R.drawable.a131, R.drawable.a132);
        ans.put(R.drawable.a141, R.drawable.a142);
        ans.put(R.drawable.a151, R.drawable.a152);
        ans.put(R.drawable.a161, R.drawable.a162);
    }

    public static boolean isMatch(int head, int img) {
        return ans.get(head) == img;
    }


}
