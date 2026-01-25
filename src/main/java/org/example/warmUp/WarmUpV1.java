package org.example.warmUp;

public class WarmUpV1 {

    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation){
            return true;
        }
        return false;
    }

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if(aSmile && bSmile) return true;
        if(!aSmile && !bSmile) return true;
        if (aSmile || bSmile ) return false;
        return false;
    }

}
