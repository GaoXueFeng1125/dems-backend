package edu.sugon.demsbackend.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class Result<T> implements Serializable {
    /**
     * 通信数据
     */
    private T data;
    /**
     * 通信状态
     */
    private boolean success = true;
    /**
     * 通信描述
     */
    private String msg = "操作成功";

    public static <T> Result<T> success(){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        return result;
    }
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }
    public static <T> Result<T> error(String msg){
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }



}
