package com.example.thisfruit;

public class FruitMatch {
    private int handPaint;
    private int realPaint;

    FruitMatch(int handPainting,int realPainting){
        handPaint = handPainting;
        realPaint = realPainting;
    }

    public int getHandPaint(){return this.handPaint;}

    public int getRealPaint(){return this.realPaint;}

}
