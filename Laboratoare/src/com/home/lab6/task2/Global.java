package com.home.lab6.task2;

public class Global {
    private static int num;
    static{
        setNum(5);
    }

     public static int Left(int i){
         final int idx = (i - 1 + getNum()) % getNum();
         return idx;
    }
     public static int Right(int i){
         final int idx = (i + 1) % getNum();
         return idx;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Global.num = num;
    }
}
