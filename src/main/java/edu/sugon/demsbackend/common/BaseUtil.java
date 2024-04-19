package edu.sugon.demsbackend.common;

public class BaseUtil {
    public static boolean hasSpaceChar(String str){
        return str.contains(" ");
    }
    public static boolean strIsEmpty(String str){
        return str.equals("");
    }
    public static boolean isPositiveInt(String str){
        return str.matches("^[0-9]*$") && str.length()>0 && !(str.charAt(0) == '0');
    }
}
