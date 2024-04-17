package edu.sugon.demsbackend.common;

public class BaseUtil {
    public static boolean hasSpaceChar(String str){
        return str.contains(" ");
    }
    public static boolean strIsEmpty(String str){
        return str.equals("");
    }
}
