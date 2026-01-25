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
    public int sumDouble(int a, int b) {
        int sum=a+b;
        if(a==b){
            sum=sum*2;
        }

        return sum;
    }
    public int diff21(int n) {
        if(n<= 21){
            return 21-n;
        }else{
            return(n-21)*2;
        }
    }
    public boolean parrotTrouble(boolean talking, int hour) {
        return(talking && (hour<7 || hour>20));
    }
    public boolean makes10(int a, int b) {
        if(a==10 || b==10) return true;
        else if (a+b == 10) return true;
        return false;
    }
    public boolean nearHundred(int n) {
        if(n >=90 && n<=110) return true;
        if(n>= 190 && n<= 210) return true;
        return false;
    }
    public boolean posNeg(int a, int b, boolean negative) {
        if ( negative == true && a<0 && b <0) return true;
        if(a<0 && b>0 && negative !=true) return true;
        if(a>0 && b<0 && negative != true) return true;
        return false;
    }
    public String notString(String str) {
        if(str.startsWith("not")) return str;
        return "not ".concat(str);
    }
    public String missingChar(String str, int n) {
        StringBuilder word = new StringBuilder(str);
        word.deleteCharAt(n);
        return word.toString();
    }
    public String frontBack(String str) {
        if(str.length() <= 1)return str;
        return str.substring(str.length()-1).concat(str.substring(1,str.length()-1)).concat(str.substring(0,1));
    }
    public String front3(String str) {
        if (str.length() <1) return str;
        if(str.length()<=3) return str.concat(str).concat(str);
        return str.substring(0,3).concat(str.substring(0,3)).concat(str.substring(0,3));
    }
}
