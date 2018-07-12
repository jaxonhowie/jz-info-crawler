package org.jz.commons;

/**
 * @author Hongyi Zheng
 * @date 2018/7/12
 */
public class Result {

    private String code;
    private String message;
    private Object data;

    public Result() {
        buildResult(null, null, null);
    }

    public Result(RspCode rspCode) {
        buildResult(rspCode, null, null);
    }

    public Result(RspCode rspCode, String msg) {
        buildResult(rspCode, msg, null);
    }

    public Result(Object data) {
        buildResult(null, null, data);
    }

    public Result(RspCode rspCode, String msg, Object data) {
        buildResult(rspCode, msg, data);
    }


    private void buildResult(RspCode rspCode, String msg, Object data) {
        rspCode = (rspCode == null ? RspCode.SUCCESS : rspCode);
        this.code = rspCode.code();
        this.message = (msg == null ? rspCode.message() : rspCode.message() + ":" + msg);
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
