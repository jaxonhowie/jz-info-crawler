package org.jz.controller;

import org.jz.commons.Result;
import org.jz.commons.RspCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Hongyi Zheng
 * @date 2018/7/12
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 获取request
     *
     * @return req
     */
    protected HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    }

    /**
     * 获取response
     *
     * @return resp
     */
    protected HttpServletResponse getResponse(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 返回-成功但不返回数据
     */
    protected Result result() {
        return new Result();
    }

    /**
     * 返回-成功并返回数据
     */
    protected Result result(Object data) {
        return new Result(data);
    }

    /**
     * 返回-只返回错误码，用于异常情况
     */
    protected Result result(RspCode rspCode) {
        return new Result(rspCode);
    }

    /**
     * 返回-只返回错误码并自定义错误信息，用于异常情况
     */
    protected Result result(RspCode rspCode, String msg) {
        return new Result(rspCode, msg);
    }


}
